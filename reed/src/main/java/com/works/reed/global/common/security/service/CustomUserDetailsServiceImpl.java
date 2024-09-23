package com.works.reed.global.common.security.service;

import com.works.reed.domain.member.dao.MemberRepository;
import com.works.reed.domain.member.domain.MemberEntity;
import com.works.reed.domain.member.exception.NotFoundMemberException;
import com.works.reed.global.common.security.principal.MemberPrincipal;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsServiceImpl implements CustomUserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MemberEntity member = memberRepository.findByEmail(username)
                .orElseThrow(() -> new NotFoundMemberException());
        return MemberPrincipal.create(member);
    }

}
