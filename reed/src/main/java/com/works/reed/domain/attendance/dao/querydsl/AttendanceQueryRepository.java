package com.works.reed.domain.attendance.dao.querydsl;

import com.works.reed.domain.attendance.dto.NonAttendance;
import com.works.reed.global.common.dto.request.PageRequest;

import java.util.List;

public interface AttendanceQueryRepository {
    List<NonAttendance> findNonAttendance(PageRequest pageRequest);
}
