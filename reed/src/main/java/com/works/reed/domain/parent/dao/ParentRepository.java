package com.works.reed.domain.parent.dao;


import com.works.reed.domain.parent.domain.ParentEntity;
import com.works.reed.domain.parent.domain.id.ParentId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ParentRepository extends JpaRepository<ParentEntity, ParentId> {

}
