package com.works.reed.domain.teacher.dto;

import com.works.reed.domain.teacher.enums.EducationType;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {
    private Long id;
    private EducationType education;
}
