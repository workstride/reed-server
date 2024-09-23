package com.works.reed.domain.parent.mapper;

import com.works.reed.domain.parent.domain.ParentEntity;
import com.works.reed.domain.parent.domain.id.ParentId;
import com.works.reed.domain.parent.dto.Parent;
import org.springframework.stereotype.Component;

@Component
public class ParentMapper {
    public ParentEntity createParent(Parent parent) {
        return ParentEntity.builder()
                .id(createParentId(parent))
                .build();
    }

    public ParentId createParentId(Parent parent) {
        return ParentId.builder().memberId(parent.getMemberId()).childId(parent.getChildId()).build();
    }

}
