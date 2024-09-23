package com.works.reed.domain.member.application;

import com.works.reed.domain.member.domain.MemberEntity;
import com.works.reed.domain.member.dto.Member;

import java.util.Optional;

public interface MemberService {
    void register(Member member);
    void duplicateMemberEmail(String email);
    void delete(Long id);
    Member findById(Long id);

}
