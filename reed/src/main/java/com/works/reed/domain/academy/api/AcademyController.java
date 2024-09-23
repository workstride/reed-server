package com.works.reed.domain.academy.api;

import com.works.reed.domain.academy.application.AcademyService;
import com.works.reed.domain.academy.application.querdsl.AcademyQueryService;
import com.works.reed.domain.academy.dto.AcademyInfo;
import com.works.reed.domain.academy.dto.request.*;
import com.works.reed.global.common.dto.response.PageResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Tag(name = "학원", description = "학원")
@SecurityRequirement(name = "BearerAuthentication")

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/academy")
public class AcademyController {

    private final AcademyService service;
    private final AcademyQueryService academyQueryService;

    //@PreAuthorize("hasAnyRole('ROLE_TEACHER')")
    @Operation(summary = "학원 등록", description = "학원 등록 (원장)")
    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public void register(@Validated @RequestBody AcademyRegisterRequest request) {
        service.register(request.toAcademy());
    }

    @Operation(summary = "학원 리스트 조회", description = "학원 리스트 조회 (원장)")
    @GetMapping("")
    public PageResponse<List<AcademyInfo>> findAcademy(@ModelAttribute AcademyPageRequest request) {
        return academyQueryService.findAcademy(request);
    }

    @Operation(summary = "학원 조회", description = "학원 조회 (원장)")
    @GetMapping("/{academyId}")
    public ResponseEntity findAcademyByAcno(@PathVariable("academyId") Long academyId) {
        return ResponseEntity.ok(academyQueryService.findByAcademyId(academyId));
    }

    @Operation(summary = "학원 수정", description = "학원 수정 (원장)")
    @PutMapping("")
    public void modAcademy() {

    }

    @Operation(summary = "학원 삭제", description = "학원 삭제 (원장)")
    @DeleteMapping("/{academyId}")
    public void removeAcademy(@PathVariable("academyId") Long academyId) {
        service.remove(academyId);
    }

    @Operation(summary = "학원 선생님 등록", description = "학원 선생님 등록 (원장)")
    @PostMapping("/teacher")
    @ResponseStatus(HttpStatus.CREATED)
    public void registerTeacher(@Validated @RequestBody AcademyTeacherRequest request) {
        service.registerTeacher(request.toAcadTeacher());
    }

    @Operation(summary = "학원 선생님 삭제", description = "학원 선생님 삭제 (원장)")
    @DeleteMapping("/teacher")
    public void removeTeacher(@Validated @RequestBody AcademyTeacherRequest request) {
        service.removeTeacher(request.toAcadTeacher());
    }

    @Operation(summary = "학원 선생님 리스트 조회", description = "학원 선생님 리스트 조회 (원장)")
    @GetMapping("/teacher/list")
    public PageResponse findAcademyTeachers(@ModelAttribute AcadTeacherPageRequest request) {
        return academyQueryService.findAcademyTeachers(request);
    }


    @Operation(summary = "학원 학생 등록", description = "학원 학생 등록 (원장, 선생님)")
    @PostMapping("/student")
    @ResponseStatus(HttpStatus.CREATED)
    public void registerStudent(@Validated @RequestBody AcademyStudentRequest request) {
        service.registerStudent(request.toAcadStudent());
    }

    @Operation(summary = "학원 학생 리스트 조회", description = "학원 학생 리스트 조회 (원장, 선생님)")
    @GetMapping("/student/list")
    public PageResponse findAcademyStudents(@ModelAttribute AcadStudentPageRequest request) {
        return academyQueryService.findAcademyStudents(request);
    }

    @Operation(summary = "학원 학생 삭제", description = "학원 학생 삭제 (원장, 선생님)")
    @DeleteMapping("/student")
    public void removeStudent(@Validated @RequestBody AcademyStudentRequest request) {
        service.removeStudent(request.toAcadStudent());
    }

}
