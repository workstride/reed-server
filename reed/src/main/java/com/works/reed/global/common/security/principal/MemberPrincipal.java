package com.works.reed.global.common.security.principal;

import com.works.reed.domain.member.domain.MemberEntity;
import com.works.reed.domain.member.dto.Member;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

@Getter
public class MemberPrincipal implements UserDetails {

    private final MemberEntity member;
    private Collection<? extends GrantedAuthority> authorities;

    private MemberPrincipal(final MemberEntity member, final Collection<? extends GrantedAuthority> authorities) {
        this.member = member;
        this.authorities = authorities;
    }

    public static MemberPrincipal create(MemberEntity member) {
        return new MemberPrincipal(member, Collections.singletonList(new SimpleGrantedAuthority(member.getRole().getKey())).stream().toList());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return member.getPw();
    }

    @Override
    public String getUsername() {
        return member.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public Member toMember() {
        return Member.builder()
                .id(member.getId())
                .email(member.getEmail())
                .name(member.getName())
                .gender(member.getGender())
                .birth(member.getBirth())
                .tel(member.getTel())
                .build();
    }

}
