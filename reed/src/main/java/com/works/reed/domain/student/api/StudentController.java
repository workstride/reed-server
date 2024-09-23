package com.works.reed.domain.student.api;


import com.works.reed.domain.student.application.StudentService;
import com.works.reed.domain.student.application.querydsl.StudentQueryService;
import com.works.reed.domain.student.dto.request.StudentModifyRequest;
import com.works.reed.domain.student.dto.request.StudentPageRequest;
import com.works.reed.domain.student.dto.request.StudentRegisterRequest;
import com.works.reed.global.common.dto.response.PageResponse;
import com.works.reed.global.infra.neis.dto.request.NeisSchoolInfoRequest;
import com.works.reed.global.infra.neis.dto.request.NeisSchoolScheduleRequest;
import com.works.reed.global.infra.neis.service.NeisService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Tag(name = "학생", description = "학생")
@SecurityRequirement(name = "BearerAuthentication")

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/student")
public class StudentController {

    private final StudentService service;
    private final StudentQueryService studentQueryService;
    private final NeisService neisService;

    @Operation(summary = "학생 등록", description = "학생 등록")
    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public void register(@Validated @RequestBody StudentRegisterRequest request) {
        service.register(request.toStudent());
    }

    @PreAuthorize("hasAnyRole('ROLE_TEACHER', 'ROLE_HEAD_TEACHER')")
    @Operation(summary = "학생 리스트 조회", description = "학생 리스트 조회 (선생님, 원장)")
    @GetMapping("/list")
    public PageResponse list(@ModelAttribute StudentPageRequest request) {
        return studentQueryService.findStudents(request);
    }

    @Operation(summary = "학생 수정", description = "학생 수정")
    @PutMapping("")
    public void modify(@Validated @RequestBody StudentModifyRequest request) {

    }

    @Operation(summary = "학교 정보", description = "학교 정보")
    @GetMapping("/school/list")
    public PageResponse findSchoolInfo(@Validated @ModelAttribute NeisSchoolInfoRequest request) {
        return neisService.getSchoolInfo(request);
    }

    @Operation(summary = "학교 일정", description = "학교 일정")
    @GetMapping("/schedule")
    public PageResponse findSchoolInfo(@Validated @ModelAttribute NeisSchoolScheduleRequest request) {
        return neisService.getSchoolSchedule(request);

    }


}
