package com.works.reed.domain.mail.application;

import com.works.reed.domain.mail.dto.Email;
import com.works.reed.domain.mail.dto.request.EmailRequest;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;

@Service
public interface MailService  {
    public MimeMessage createMessage(String to)throws MessagingException, UnsupportedEncodingException;
    public String sendMail(Email to)throws Exception;

    Email verified(EmailRequest email);
}
