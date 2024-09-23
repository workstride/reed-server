package com.works.reed.domain.student.dto;

import com.works.reed.domain.member.enums.GenderType;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentInfo {
    private Long id;
    private String schulName;
    private String atptOfcdcScCode;
    private String sdSchulCode;
    private String email;
    private String name;
    private GenderType gender;
    private LocalDate birth;
    private String tel;
    private LocalDateTime scRegDate, scModDate;
}
