package com.works.reed.domain.course.dto;


import com.works.reed.domain.academy.dto.AcadStudent;
import com.works.reed.domain.academy.dto.AcadTeacher;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CourseStudent {
    private Long id;
    private AcadStudent academyStudent;
    private Long courseId;
}

