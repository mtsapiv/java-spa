package com.mtsapiv.javaspabackend;

import com.mtsapiv.javaspabackend.configuration.SecurityProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(SecurityProperties.class)
public class JavaSpaBackendApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(JavaSpaBackendApplication.class, args);
    }
}
