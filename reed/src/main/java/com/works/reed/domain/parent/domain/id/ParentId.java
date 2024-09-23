package com.works.reed.domain.parent.domain.id;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;
import java.util.Objects;


@Embeddable
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
public class ParentId implements Serializable {

    @Column(name = "mem_id", nullable = false)
    @EqualsAndHashCode.Include
    private Long memberId;

    @Column(name = "child_id", nullable = false)
    @EqualsAndHashCode.Include
    private Long childId;

}
