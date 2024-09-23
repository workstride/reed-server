package com.works.reed.domain.announcement.api;

import com.works.reed.domain.announcement.application.AnnounceService;
import com.works.reed.domain.announcement.application.querydsl.AnnounceQueryService;
import com.works.reed.domain.announcement.dto.AnnounceInfo;
import com.works.reed.domain.announcement.dto.request.AnnouncePageRequest;
import com.works.reed.domain.announcement.dto.request.AnnounceRequest;
import com.works.reed.global.common.dto.response.PageResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "공지", description = "공지")
@SecurityRequirement(name = "BearerAuthentication")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/ann")
public class AnnounceController {

    private final AnnounceService announceService;
    private final AnnounceQueryService announceQueryService;

    @Operation(summary = "공지 업로드", description = "공지 업로드")
    @PostMapping("/upload")
    @ResponseStatus(HttpStatus.CREATED)
    public void upload(@Validated @RequestBody AnnounceRequest announce) {
        announceService.upload(announce);
    }

    @Operation(summary = "공지 수정", description = "공지 수정")
    @PutMapping("{id}")
    public void edit(AnnounceRequest request, @PathVariable Long id) {
        announceService.edit(request, id);
    }

    @Operation(summary = "공지 삭제", description = "공지 삭제")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        announceService.delete(id);
    }

    @Operation(summary = "공지 리스트", description = "공지 리스트")
    @GetMapping("/list")
    public PageResponse<List<AnnounceInfo>> findAnnounces(@ModelAttribute AnnouncePageRequest pageRequest) {
        return announceQueryService.findAnnounces(pageRequest);
    }

    @Operation(summary = "공지 읽기", description = "공지 읽기")
    @GetMapping("/{id}")
    public AnnounceInfo findById(@PathVariable Long id) {
        return announceService.read(id);
    }

}
