package com.works.reed.domain.academy.domain.id;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;
import java.util.Objects;


@Embeddable
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
public class AcadMemberId implements Serializable {

    @Column(name = "acd_id", nullable = false)
    private Long academyId;
    @Column(name = "mem_id", nullable = false)
    private Long memberId;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AcadMemberId acadMemberId = (AcadMemberId) o;
        return Objects.equals(academyId, acadMemberId.academyId) &&
                Objects.equals(memberId, acadMemberId.memberId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(academyId, memberId);
    }
}
