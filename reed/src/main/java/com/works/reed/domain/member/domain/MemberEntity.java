package com.works.reed.domain.member.domain;


import com.works.reed.domain.member.dto.Member;
import com.works.reed.domain.member.enums.GenderType;
import com.works.reed.domain.member.enums.MemberRole;
import com.works.reed.global.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.Optional;

@Entity
@Table(name = "tbl_member")
@Getter
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String pw;

    @Column(nullable = false)
    private GenderType gender;

    @Column(nullable = false)
    private LocalDate birth;

    @Column(nullable = false, length = 20)
    private String name;

    @Column(nullable = false, length = 12)
    private String tel;

    @Enumerated(value = EnumType.STRING)
    private MemberRole role;


}
