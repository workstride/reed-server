package com.works.reed.domain.attendance.dao;

import com.works.reed.domain.attendance.domain.AttendanceCodeEntity;
import com.works.reed.domain.attendance.domain.enums.AttendanceCodeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface AttendanceCodeRepository extends JpaRepository<AttendanceCodeEntity, Long> {

    @Modifying
    @Query("UPDATE AttendanceCodeEntity ac SET ac.active=false WHERE ac.courseId=:courseId AND type=:type")
    void expireCode(@Param("courseId") Long courseId, @Param("type") AttendanceCodeType type);

    @Query("SELECT ac FROM AttendanceCodeEntity ac WHERE active=true AND code=:code AND type=:type")
    Optional<AttendanceCodeEntity> findByActiveCode(@Param("code") String code, @Param("type") AttendanceCodeType type);

}
