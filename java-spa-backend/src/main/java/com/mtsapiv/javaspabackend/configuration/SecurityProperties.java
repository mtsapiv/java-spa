package com.mtsapiv.javaspabackend.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties("security")
@Component
@Data
public class SecurityProperties {
    private String username;
    private String password;
    private String role;
}
