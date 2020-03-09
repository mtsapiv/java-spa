package com.mtsapiv.javaspabackend.configurations;


import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "database")
@Getter
public class Database {

    private String connector;
    private String  host;
    private String  user;
    private String password;
    private String db_name;
}
