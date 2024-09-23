package com.works.reed.domain.notification.dao;

import com.works.reed.domain.auth.dto.request.AuthRequest;

public interface FCMTokenRepository {
    void saveToken(AuthRequest authRequest);

    String getToken(String id);

    void deleteToken(String id);

    boolean hasKey(String email);

}
