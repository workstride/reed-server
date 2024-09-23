package com.works.reed.domain.member.application.querydsl;

import com.works.reed.domain.member.dao.querydsl.MemberQueryRepository;
import com.works.reed.domain.member.dto.MemberInfo;
import com.works.reed.domain.member.dto.request.MemberPageRequest;
import com.works.reed.domain.member.exception.NotFoundMemberException;
import com.works.reed.global.common.dao.MemberSecurity;
import com.works.reed.global.common.dto.response.PageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
@Service
@RequiredArgsConstructor
public class MemberQueryServiceImpl implements MemberQueryService {

    private final MemberQueryRepository memberQueryRepository;
    private final MemberSecurity memberSecurity;

    @Override
    public PageResponse<List<MemberInfo>> findMembers(MemberPageRequest request) {
        Page<MemberInfo> result = memberQueryRepository.findMembers(request);
        return new PageResponse<List<MemberInfo>>(result.toList(), result.getTotalPages());
    }

    @Override
    public MemberInfo findMember() {
        return memberQueryRepository.findMember(memberSecurity.getMember().getId()).orElseThrow(() -> NotFoundMemberException.EXCEPTION);
    }


}
