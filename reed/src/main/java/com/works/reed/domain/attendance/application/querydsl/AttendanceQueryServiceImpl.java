package com.works.reed.domain.attendance.application.querydsl;

import com.works.reed.domain.attendance.dao.querydsl.AttendanceQueryRepository;
import com.works.reed.domain.attendance.dto.NonAttendance;
import com.works.reed.global.common.dto.request.PageRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class AttendanceQueryServiceImpl implements AttendanceQueryService {

    private final AttendanceQueryRepository attendanceQueryRepository;

    @Override
    public List<NonAttendance> findNonAttendance(PageRequest pageRequest) {
        return attendanceQueryRepository.findNonAttendance(pageRequest);
    }

}
