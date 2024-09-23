package com.works.reed.domain.mail.application;

import com.google.api.client.util.Value;
import com.works.reed.domain.mail.dto.Email;
import com.works.reed.domain.mail.dto.request.EmailRequest;
import com.works.reed.domain.mail.exception.MismatchEmailKeyException;
import com.works.reed.domain.mail.exception.NotFoundEmailException;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@Slf4j
@RequiredArgsConstructor
public class MailServiceImpl implements MailService {
    private final JavaMailSender javaMailSender;

    private String mailKey;
    private String email;

    @Value("${spring.mail.username}")
    private String id;

    private String createKey() {
        StringBuilder key = new StringBuilder();
        Random rnd = new Random();

        for (int i = 0; i < 6; i++) { // 인증코드 6자리
            key.append((rnd.nextInt(10)));
        }
        return key.toString();
    }

    public MimeMessage createMessage(String mail)throws MessagingException {
        mailKey = createKey();
        MimeMessage message = javaMailSender.createMimeMessage();

        message.addRecipients(MimeMessage.RecipientType.TO, mail);
        message.setFrom(id);
        message.setSubject("Reed 회원가입 인증 코드");
        String msg = "안녕하세요 Reed 서비스입니다." +
                "인증번호는 " + mailKey + "입니다.";

        message.setText(msg, "utf-8", "html");

        email = mail;

        return message;
    }

    public String sendMail(Email mail)throws Exception {
        MimeMessage message = createMessage(mail.getEmail());

        if(!mail.getEmail().equals(email)) {
            throw NotFoundEmailException.EXCEPTION;
        }

        try{
            javaMailSender.send(message);
        }catch(MailException es){
            es.printStackTrace();
            throw new IllegalArgumentException();
        }

        return mailKey;
    }

    public Email verified(EmailRequest mail) {
        if(!mail.getEmail().equals(email)) {
            throw NotFoundEmailException.EXCEPTION;
        }
        if(!mail.getKey().equals(mailKey)) {
            throw MismatchEmailKeyException.EXCEPTION;
        }

        return Email.builder().email(email).build();
    }

}
