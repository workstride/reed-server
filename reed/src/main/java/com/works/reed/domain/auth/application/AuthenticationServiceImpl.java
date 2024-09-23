package com.works.reed.domain.auth.application;

import com.works.reed.domain.auth.dto.request.AuthRequest;
import com.works.reed.global.common.dto.response.TokenResponse;
import com.works.reed.global.common.jwt.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class AuthenticationServiceImpl implements AuthenticationService {

    private final JwtProvider jwtProvider;
    private final AuthenticationManager authenticationManager;

    @Override
    public TokenResponse auth(AuthRequest authRequest) {
        Authentication authenticate = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPw()));
        return jwtProvider.createToken((UserDetails) authenticate.getPrincipal());
    }

    @Override
    public TokenResponse refreshToken(String refreshToken) {
        return jwtProvider.refreshToken(refreshToken);
    }

}
