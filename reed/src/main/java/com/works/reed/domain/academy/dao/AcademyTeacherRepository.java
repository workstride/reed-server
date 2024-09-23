package com.works.reed.domain.academy.dao;

import com.works.reed.domain.academy.domain.AcadTeacherEntity;
import com.works.reed.domain.academy.domain.id.AcadMemberId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface AcademyTeacherRepository extends JpaRepository<AcadTeacherEntity, AcadMemberId> {
//    @Query("SELECT t FROM AcadTeacher t WHERE t.acadMemberId")
//    Optional<AcadTeacherEntity> findByAcademyIdAndMemberId(Long academyId, Long memberId);
}
