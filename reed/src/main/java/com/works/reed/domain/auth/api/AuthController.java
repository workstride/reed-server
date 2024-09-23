package com.works.reed.domain.auth.api;

import com.works.reed.domain.auth.application.AuthenticationService;
import com.works.reed.domain.auth.dto.request.AuthRequest;
import com.works.reed.domain.auth.dto.request.RegisterRequest;
import com.works.reed.domain.member.application.MemberService;
import com.works.reed.domain.notification.application.NotificationService;
import com.works.reed.global.common.dto.response.TokenResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Email;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Tag(name = "인증", description = "인증")
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationService service;
    private final MemberService memberService;
    private final NotificationService notificationService;

    @Operation(summary = "회원 가입", description = "회원 가입")
    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public void register(@Validated @RequestBody RegisterRequest registerRequest) {
        memberService.register(registerRequest.toMember());
    }

    @Operation(summary = "회원 이메일 중복 체크", description = "회원 이메일 중복 체크")
    @GetMapping("/validate/email")
    @ResponseStatus(HttpStatus.OK)
    public void duplicateMemberId(@RequestParam(name = "email") String email){
        memberService.duplicateMemberEmail(email);
    }

    @Operation(summary = "회원 인증", description = "회원 인증")
    @PostMapping("")
    public ResponseEntity<TokenResponse> authenticate(@Validated @RequestBody AuthRequest authRequest) {
        TokenResponse tokenResponse = service.auth(authRequest);
        notificationService.saveToken(authRequest);
        return ResponseEntity.ok(tokenResponse);
    }

    @Operation(summary = "토큰 재발급", description = "토근 재발급")
    @PostMapping("/refresh")
    public TokenResponse refresh(@RequestHeader(value = HttpHeaders.AUTHORIZATION) String refreshToken) {
        return service.refreshToken(refreshToken);
    }

}
