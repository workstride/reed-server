package com.works.reed.domain.teacher.api;


import com.works.reed.domain.teacher.application.TeacherService;
import com.works.reed.domain.teacher.application.querdsl.TeacherQueryService;
import com.works.reed.domain.teacher.dto.request.TeacherModifyRequest;
import com.works.reed.domain.teacher.dto.request.TeacherPageRequest;
import com.works.reed.domain.teacher.dto.request.TeacherRegisterRequest;
import com.works.reed.domain.teacher.dto.request.TeacherRemoveRequest;
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

@Tag(name = "선생님", description = "선생님")
@SecurityRequirement(name = "BearerAuthentication")

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/teacher")
public class TeacherController {

    private final TeacherService service;
    private final TeacherQueryService teacherQueryService;

    @Operation(summary = "선생님 등록", description = "선생님 등록")
    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public void register(@Validated @RequestBody TeacherRegisterRequest request) {
        service.register(request.toTeacher());
    }

    @Operation(summary = "선생님 조회", description = "선생님 조회")
    @GetMapping("/{id}")
    public ResponseEntity findTeacherById(@PathVariable("id") Long id) {
        return teacherQueryService.findTeacherById(id);
    }

    @Operation(summary = "선생님 리스트 조회", description = "학생 리스트 조회")
    @GetMapping("/list")
    public PageResponse list(@ModelAttribute TeacherPageRequest request) {
        return teacherQueryService.findTeachers(request);
    }

    @Operation(summary = "선생님 수정", description = "선생님 수정")
    @PutMapping("")
    public void modify(@Validated @RequestBody TeacherModifyRequest request) {
        service.modify(request.toTeacher());
    }

    @Operation(summary = "선생님 삭제", description = "선생님 삭제")
    @DeleteMapping("")
    public void remove(@Validated @RequestBody TeacherRemoveRequest request) {
        service.remove(request.toTeacher());
    }

}
