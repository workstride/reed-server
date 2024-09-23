package com.works.reed.global.batch.writer;

import com.works.reed.domain.notification.application.NotificationService;
import com.works.reed.domain.notification.dto.Notification;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
public class AttendanceItemWriter implements ItemWriter<List<Notification>> {

    private final NotificationService notificationService;

    @Override
    public void write(Chunk<? extends List<Notification>> chunk) throws Exception {
        log.info("....................... AttendanceItemWriter start");

        for (List<Notification> notificationList : chunk.getItems()) {
            for (Notification notification : notificationList) {
                notificationService.sendNotification(notification);
            }
        }

        log.info("....................... AttendanceItemWriter end");
    }

}
