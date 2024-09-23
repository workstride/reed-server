package com.works.reed.domain.member.application.querydsl;

import com.works.reed.domain.member.dto.MemberInfo;
import com.works.reed.domain.member.dto.request.MemberPageRequest;
import com.works.reed.global.common.dto.response.PageResponse;

import java.util.List;

public interface MemberQueryService {
    PageResponse<List<MemberInfo>> findMembers(MemberPageRequest request);

    MemberInfo findMember();
}
