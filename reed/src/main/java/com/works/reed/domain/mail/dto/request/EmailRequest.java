package com.works.reed.domain.mail.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmailRequest {
    private String email;
    private String key;
}
