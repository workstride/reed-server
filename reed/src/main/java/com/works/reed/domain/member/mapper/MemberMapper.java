package com.works.reed.domain.member.mapper;

import com.works.reed.domain.member.domain.MemberEntity;
import com.works.reed.domain.member.dto.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class MemberMapper {

    private final PasswordEncoder passwordEncoder;

    public MemberEntity createEntity(Member member) {
        return MemberEntity.builder()
                .id(member.getId())
                .email(member.getEmail())
                .pw(passwordEncoder.encode(member.getPw()))
                .gender(member.getGender())
                .birth(member.getBirth())
                .email(member.getEmail())
                .name(member.getName())
                .tel(member.getTel())
                .role(member.getRole())
                .build();
    }

    public Member CreateDto(Optional<MemberEntity> entity) {
        MemberEntity member = entity.get();
        return Member.builder()
                .id(member.getId())
                .email(member.getEmail())
                .pw(passwordEncoder.encode(member.getPw()))
                .gender(member.getGender())
                .birth(member.getBirth())
                .name(member.getName())
                .tel(member.getTel())
                .role(member.getRole())
                .build();
    }

}
