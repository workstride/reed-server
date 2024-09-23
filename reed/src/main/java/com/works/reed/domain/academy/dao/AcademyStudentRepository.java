package com.works.reed.domain.academy.dao;

import com.works.reed.domain.academy.domain.AcadStudentEntity;
import com.works.reed.domain.academy.domain.id.AcadMemberId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AcademyStudentRepository extends JpaRepository<AcadStudentEntity, AcadMemberId> {
}
