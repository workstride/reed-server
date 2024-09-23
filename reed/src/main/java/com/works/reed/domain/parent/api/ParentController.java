package com.works.reed.domain.parent.api;

import com.works.reed.domain.parent.application.ParentService;
import com.works.reed.domain.parent.application.querydsl.ParentQueryService;
import com.works.reed.domain.parent.dto.request.ParentRegisterRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Tag(name = "보호자", description = "보호자")
@SecurityRequirement(name = "BearerAuthentication")

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/parent")
public class ParentController {

    private final ParentService service;
    private final ParentQueryService parentQueryService;

    @Operation(summary = "보호자 등록", description = "보호자 등록")
    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public void register(@Validated @RequestBody ParentRegisterRequest request) {
        service.register(request.toParent());
    }

}
