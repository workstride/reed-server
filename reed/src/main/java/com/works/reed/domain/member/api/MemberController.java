package com.works.reed.domain.member.api;

import com.works.reed.domain.member.application.MemberService;
import com.works.reed.domain.member.application.querydsl.MemberQueryService;
import com.works.reed.domain.member.dto.Member;
import com.works.reed.domain.member.dto.MemberInfo;
import com.works.reed.domain.member.dto.request.MemberPageRequest;
import com.works.reed.global.common.dto.response.PageResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@Tag(name = "회원", description = "회원")
@SecurityRequirement(name = "BearerAuthentication")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/member")
public class MemberController {

    private final MemberService memberService;
    private final MemberQueryService memberQueryService;

    @Operation(summary = "회원 조회", description = "회원 조회")
    @GetMapping("/list")
    public PageResponse findMembers(@ModelAttribute MemberPageRequest request) {
        return memberQueryService.findMembers(request);
    }

    @Operation(summary = "회원 정보", description = "회원 정보")
    @GetMapping("/profile")
    public MemberInfo profile() {
        return memberQueryService.findMember();
    }

    @Operation(summary = "단일 회원 조회", description = "단일 회원 조회")
    @GetMapping("/{id}")
    public Member findMember(@PathVariable Long id) {
        return memberService.findById(id);
    }

    @Operation(summary = "회원 삭제", description = "회원 삭제")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        memberService.delete(id);
    }

}
