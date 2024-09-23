package com.works.reed.domain.notification.application;

import com.google.firebase.messaging.*;
import com.works.reed.domain.auth.dto.request.AuthRequest;
import com.works.reed.domain.notification.dao.FCMTokenRepository;
import com.works.reed.domain.notification.dto.Notification;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {

    private final FCMTokenRepository fcmTokenRepository;

    @Async
    public void sendNotification(Notification notification) throws ExecutionException, InterruptedException {
        List<String> registrationTokens = new ArrayList<>();

        notification.getEmails().forEach(email -> {
            if (hasKey(email)) {
                registrationTokens.add(getToken(email));
            }
        });
        if (registrationTokens.size() > 0)
            send(createMessage(registrationTokens, createNotification(notification), createApnsConfig()));
    }

    private void send(MulticastMessage message) throws ExecutionException, InterruptedException {
        FirebaseMessaging.getInstance().sendEachForMulticastAsync(message).get();
    }

    private void send(Message message) throws ExecutionException, InterruptedException {
        FirebaseMessaging.getInstance().sendAsync(message).get();
    }

    private MulticastMessage createMessage(List<String> registrationTokens, com.google.firebase.messaging.Notification notification, ApnsConfig apnsConfig) {

        return MulticastMessage.builder()
                .setNotification(notification)
                .setApnsConfig(apnsConfig)
                .addAllTokens(registrationTokens)
                .build();
    }

    private ApnsConfig createApnsConfig() {
        return ApnsConfig.builder().setAps(Aps.builder().setSound("default").build()).build();
    }

    private com.google.firebase.messaging.Notification createNotification(Notification notification) {
        return com.google.firebase.messaging.Notification.builder()
                .setTitle(notification.getTitle())
                .setBody(notification.getMessage()).build();
    }

    public void saveToken(AuthRequest authRequest) {
        if (StringUtils.hasText(authRequest.getToken()))
            fcmTokenRepository.saveToken(authRequest);
    }

    public void deleteToken(String email) {
        fcmTokenRepository.deleteToken(email);
    }

    private boolean hasKey(String email) {
        return fcmTokenRepository.hasKey(email);
    }

    private String getToken(String email) {
        return fcmTokenRepository.getToken(email);
    }
}
