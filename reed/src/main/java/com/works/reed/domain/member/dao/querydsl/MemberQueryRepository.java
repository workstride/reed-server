package com.works.reed.domain.member.dao.querydsl;

import com.works.reed.domain.member.dto.MemberInfo;
import com.works.reed.domain.member.dto.request.MemberPageRequest;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface MemberQueryRepository {
    Page<MemberInfo> findMembers(MemberPageRequest request);

    Optional<MemberInfo> findMember(Long memberId);
}
