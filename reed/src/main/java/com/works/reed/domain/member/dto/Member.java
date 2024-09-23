package com.works.reed.domain.member.dto;

import com.works.reed.domain.member.enums.GenderType;
import com.works.reed.domain.member.enums.MemberRole;
import lombok.*;

import java.time.LocalDate;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Member {
    private Long id;
    private String email;
    private String pw;
    private GenderType gender;
    private LocalDate birth;
    private String name;
    private String tel;
    private MemberRole role;
}
