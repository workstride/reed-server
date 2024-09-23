package com.works.reed.domain.attendance.dao;

import com.works.reed.domain.attendance.domain.AttendanceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendanceRepository extends JpaRepository<AttendanceEntity, Long> {
}
