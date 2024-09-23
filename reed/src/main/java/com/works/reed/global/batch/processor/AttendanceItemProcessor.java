package com.works.reed.global.batch.processor;

import com.works.reed.domain.attendance.dto.NonAttendance;
import com.works.reed.domain.notification.dto.Notification;
import com.works.reed.domain.parent.application.querydsl.ParentQueryService;
import com.works.reed.domain.parent.dto.ParentInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
@RequiredArgsConstructor
public class AttendanceItemProcessor implements ItemProcessor<List<NonAttendance>, List<Notification>> {

    private final ParentQueryService parentQueryService;

    @Override
    public List<Notification> process(final List<NonAttendance> readNonAttendanceList) throws Exception {
        log.info("....................... AttendanceItemProcessor start");
        final List<Notification> notificationList = new ArrayList<>();
        final Map<Long, Notification> notificationMap = new HashMap<>();
        for (NonAttendance nonAttendance : readNonAttendanceList) {

            if (!notificationMap.containsKey(nonAttendance.getCourseId())) {
                String title = String.format("%s,%s~%s", nonAttendance.getCourseName(), nonAttendance.getCourseStartTime(), nonAttendance.getCourseEndTime());
                String message = String.format("\uD83D\uDCA1 시간표를 확인해주세요!");
                Notification notification = Notification.builder()
                        .emails(new ArrayList<>())
                        .title(title)
                        .message(message).build();
                notificationMap.put(nonAttendance.getCourseId(), notification);
            }

            Notification notification = notificationMap.get(nonAttendance.getCourseId());
            notification.getEmails().add(nonAttendance.getEmail());

            final List<ParentInfo> parents = parentQueryService.findParentsByChildId(nonAttendance.getMemberId());
            if (!parents.isEmpty()) {
                String title = String.format("%s,%s~%s", nonAttendance.getCourseName(), nonAttendance.getCourseStartTime(), nonAttendance.getCourseEndTime());
                String message = String.format("%s학생\uD83D\uDCA1 미출석 안내 ", nonAttendance.getName());
                Notification parentsNotification = Notification.builder()
                        .emails(parents.stream().map(parentInfo -> parentInfo.getEmail()).collect(Collectors.toList()))
                        .title(title)
                        .message(message)
                        .build();
                notificationList.add(parentsNotification);
            }
        }
        log.info("....................... AttendanceItemProcessor end");
        return Stream.concat(notificationMap.values().stream(), notificationList.stream()).collect(Collectors.toList());
    }
}
