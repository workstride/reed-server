package com.works.reed.global.infra.neis.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "neis.api")
public class NeisProperties {
    private String key;
    private String baseUrl;
}
