package com.works.reed.domain.parent.domain;

import com.works.reed.domain.parent.domain.id.ParentId;
import com.works.reed.global.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;


@Entity
@Table(name = "tbl_parent")
@Getter
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ParentEntity extends BaseEntity {

    @EmbeddedId
    private ParentId id;

}
