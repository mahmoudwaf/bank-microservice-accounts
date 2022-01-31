package com.mahmoud.bank.accounts.config;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
@ConfigurationProperties
@Getter
@Setter
@ToString
public class AccountsConfig {
    private Map<String,String> msg;
    private String port;
}
