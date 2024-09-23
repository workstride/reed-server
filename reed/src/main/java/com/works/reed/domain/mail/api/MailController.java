package com.works.reed.domain.mail.api;

import com.works.reed.domain.mail.application.MailService;
import com.works.reed.domain.mail.dto.Email;
import com.works.reed.domain.mail.dto.request.EmailRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Tag(name = "메일", description = "메일")
@Controller
@Slf4j
@RequestMapping("/api/mail")
@RequiredArgsConstructor
public class MailController {

    private final MailService mailService;

    @Operation(summary = "인증 코드 전송", description = "인증 코드 전송")
    @PostMapping("/send")
    @ResponseStatus(HttpStatus.CREATED)
    public void mailSending(@RequestBody Email email) throws Exception {
        mailService.sendMail(email);
    }

    @Operation(summary = "인증 코드 등록", description = "인증 코드 등록")
    @GetMapping("/verify")
    public ResponseEntity<Email> mailVerify(@RequestBody EmailRequest email) {
        return ResponseEntity.ok(mailService.verified(email));
    }

}
