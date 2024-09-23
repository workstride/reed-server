package com.works.reed.global.common.jwt.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.security.SignatureException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtExceptionFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException {
        try {
            filterChain.doFilter(request, response);
        } catch (UnsupportedJwtException illegalArgumentException) {
            setErrorResponse(HttpStatus.UNAUTHORIZED, response, illegalArgumentException);
        } catch (ExpiredJwtException expiredJwtException) {
            setErrorResponse(HttpStatus.UNAUTHORIZED, response, expiredJwtException);
        } catch (MalformedJwtException malformedJwtException) {
            setErrorResponse(HttpStatus.UNAUTHORIZED, response, malformedJwtException);
        } catch (SignatureException signatureException) {
            setErrorResponse(HttpStatus.UNAUTHORIZED, response, signatureException);
        } catch (IllegalArgumentException illegalArgumentException) {
            setErrorResponse(HttpStatus.UNAUTHORIZED, response, illegalArgumentException);
        } catch (Exception ex) {
            setErrorResponse(HttpStatus.BAD_REQUEST, response, ex);
        }
//        ExpiredJwtException, UnsupportedJwtException, MalformedJwtException, SignatureException, IllegalArgumentException
    }

    public void setErrorResponse(HttpStatus status, HttpServletResponse response, Throwable ex) throws IOException {
        response.setStatus(status.value());
        ObjectMapper mapper = new ObjectMapper();
        Map<String, String> map = new HashMap<>();
        map.put("code", String.valueOf(status.value()));
        map.put("message", ex.getMessage());
        response.getWriter().write(mapper.writeValueAsString(map));
    }

}