package com.works.reed.domain.auth.application;

import com.works.reed.domain.auth.dto.request.AuthRequest;
import com.works.reed.global.common.dto.response.TokenResponse;

public interface AuthenticationService {
    TokenResponse auth(AuthRequest authRequest);
    TokenResponse refreshToken(String refreshToken);

}
