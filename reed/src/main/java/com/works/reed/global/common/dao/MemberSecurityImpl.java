package com.works.reed.global.common.dao;


import com.works.reed.domain.member.dto.Member;
import com.works.reed.global.common.security.principal.MemberPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class MemberSecurityImpl implements MemberSecurity {
    public Member getMember() {
        return ((MemberPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).toMember();
    }
}
