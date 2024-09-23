package com.works.reed.domain.student.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private Long id;
    private String schulName;
    private String atptOfcdcScCode;
    private String sdSchulCode;
}
