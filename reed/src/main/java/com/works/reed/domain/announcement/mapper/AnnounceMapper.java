package com.works.reed.domain.announcement.mapper;

import com.works.reed.domain.academy.domain.id.AcadMemberId;
import com.works.reed.domain.announcement.domain.AnnounceEntity;
import com.works.reed.domain.announcement.dto.Announce;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AnnounceMapper {
    public AnnounceEntity createEntity(Announce announce) {
        return AnnounceEntity.builder()
                .id(announce.getId())
                .acadMemberId(
                        AcadMemberId.builder()
                                .memberId(announce.getMemberId())
                                .academyId(announce.getAcademyId())
                                .build()
                )
                .annTitle(announce.getAnnTitle())
                .annContent(announce.getAnnContent())
                .build();
    }

    public Announce createDto(Optional<AnnounceEntity> ann) {

        AnnounceEntity announce = ann.get();

        return Announce.builder()
                .id(announce.getId())
                .annTitle(announce.getAnnTitle())
                .annContent(announce.getAnnContent())
                .build();

    }
}
