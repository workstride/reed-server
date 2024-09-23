package com.works.reed.domain.announcement.domain;

import com.works.reed.domain.academy.domain.id.AcadMemberId;
import com.works.reed.global.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@SuperBuilder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name = "tbl_announce")
public class AnnounceEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private AcadMemberId acadMemberId;

    @Column(name = "ann_title", length = 30, nullable = false)
    private String annTitle;

    @Column(name = "ann_content", length = 500, nullable = false)
    private String annContent;

}
