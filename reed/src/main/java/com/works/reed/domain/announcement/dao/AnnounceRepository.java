package com.works.reed.domain.announcement.dao;

import com.works.reed.domain.announcement.domain.AnnounceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnnounceRepository extends JpaRepository<AnnounceEntity, Long> {
}
