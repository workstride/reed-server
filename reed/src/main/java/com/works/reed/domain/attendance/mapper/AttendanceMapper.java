package com.works.reed.domain.attendance.mapper;

import com.works.reed.domain.academy.domain.id.AcadMemberId;
import com.works.reed.domain.attendance.domain.AttendanceCodeEntity;
import com.works.reed.domain.attendance.domain.AttendanceEntity;
import com.works.reed.domain.attendance.domain.enums.AttendanceCodeType;
import com.works.reed.domain.attendance.dto.Attendance;
import com.works.reed.domain.attendance.dto.AttendanceCode;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

@Component
public class AttendanceMapper {

    public AttendanceCodeEntity createQRCodeAttendanceCodeEntity(AttendanceCode code) {
        return AttendanceCodeEntity.builder()
                .id(code.getId())
                .courseId(code.getCourseId())
                .acadMemberId(createAcadMemberId(code.getAcademyId(), code.getMemberId()))
                .code(UUID.randomUUID().toString())
                .type(AttendanceCodeType.QRCODE)
                .active(true)
                .build();
    }

    public AttendanceEntity createAttendanceEntity(Long courseStudentId) {
        Attendance attendance = Attendance.builder().courseStudentId(courseStudentId).date(LocalDate.now()).time(LocalTime.now().truncatedTo(ChronoUnit.MINUTES)).build();
        return createAttendanceEntity(attendance);
    }

    private AttendanceEntity createAttendanceEntity(Attendance attendance) {
        return AttendanceEntity.builder()
                .id(attendance.getId())
                .courseStudentId(attendance.getCourseStudentId())
                .date(attendance.getDate())
                .time(attendance.getTime())
                .build();
    }

    public AttendanceCode toAttendanceCode(AttendanceCodeEntity attendanceCodeEntity) {
        return AttendanceCode.builder()
                .id(attendanceCodeEntity.getId())
                .courseId(attendanceCodeEntity.getCourseId())
                .memberId(attendanceCodeEntity.getAcadMemberId().getMemberId())
                .academyId(attendanceCodeEntity.getAcadMemberId().getAcademyId())
                .code(attendanceCodeEntity.getCode())
                .type(attendanceCodeEntity.getType())
                .active(attendanceCodeEntity.isActive())
                .build();
    }

    private AcadMemberId createAcadMemberId(Long academyId, Long memberId) {
        return AcadMemberId.builder().memberId(memberId).academyId(academyId).build();
    }

}
