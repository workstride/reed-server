package com.works.reed.domain.academy.dao;

import com.works.reed.domain.academy.domain.AcademyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AcademyRepository extends JpaRepository<AcademyEntity, Long> {

    Optional<AcademyEntity> findByIdAndMemberId(Long academyId, Long memberId);

}
