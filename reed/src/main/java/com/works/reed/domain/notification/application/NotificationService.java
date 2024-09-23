package com.works.reed.domain.notification.application;

import com.google.firebase.messaging.FirebaseMessagingException;
import com.works.reed.domain.auth.dto.request.AuthRequest;
import com.works.reed.domain.notification.dto.Notification;

import java.util.concurrent.ExecutionException;

public interface NotificationService {
    void sendNotification(Notification notification) throws FirebaseMessagingException, ExecutionException, InterruptedException;

    void saveToken(AuthRequest authRequest);

    void deleteToken(String email);
}
