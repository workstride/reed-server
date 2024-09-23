package com.works.reed.global.common.jwt;

import com.works.reed.global.common.dto.response.TokenResponse;
import com.works.reed.global.common.exception.UnauthorizedException;
import com.works.reed.global.common.jwt.config.JwtProperties;
import com.works.reed.global.common.security.service.CustomUserDetailsService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class JwtProvider {
    private final JwtProperties jwtProperties;
    private final CustomUserDetailsService customUserDetailsService;

    public TokenResponse createToken(UserDetails userDetails) {
        String jwtToken = generateToken(userDetails);
        String refreshToken = generateRefreshToken(userDetails);
        return TokenResponse.builder()
                .accessToken(jwtToken)
                .refreshToken(refreshToken)
                .role(userDetails.getAuthorities().stream()
                        .map(grantedAuthority -> grantedAuthority.getAuthority().replace("ROLE_", ""))
                        .findFirst()
                        .orElse(null)
                )
                .build();
    }

    public TokenResponse refreshToken(String token) {
        String jwt = token.substring(7);
        UserDetails userDetails = getUserDetails(jwt);
        if (!isTokenValid(jwt, userDetails)) {
            throw UnauthorizedException.EXCEPTION;
        }
        String jwtToken = generateToken(userDetails);
        return TokenResponse.builder()
                .accessToken(jwtToken)
                .build();
    }

    public UsernamePasswordAuthenticationToken getAuthenticationToken(String token) {
        String jwt = token.substring(7);
        UserDetails userDetails = getUserDetails(jwt);
        if (!isTokenValid(jwt, userDetails)) {
            throw new UnauthorizedException(); // <- 수정
        }
        return new UsernamePasswordAuthenticationToken(
                userDetails,
                null,
                userDetails.getAuthorities()
        );
    }

    private UserDetails getUserDetails(String jwt) {
        String username = extractUsername(jwt);
        UserDetails userDetails = customUserDetailsService.loadUserByUsername(username);
        return userDetails;
    }

    private String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    public String generateToken(UserDetails userDetails) {
        return generateToken(new HashMap<>(), userDetails);
    }

    public String generateToken(Map<String, Object> extraClaims, UserDetails userDetails) {
        return buildToken(extraClaims, userDetails, jwtProperties.getExpiration());
    }

    public String generateRefreshToken(UserDetails userDetails) {
        return buildToken(new HashMap<>(), userDetails, jwtProperties.getRefreshExpiration());
    }

    private String buildToken(Map<String, Object> extraClaims, UserDetails userDetails, long expiration) {
        return Jwts.builder()
                .setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private Key getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(jwtProperties.getSecretKey());
        return Keys.hmacShaKeyFor(keyBytes);
    }

}
