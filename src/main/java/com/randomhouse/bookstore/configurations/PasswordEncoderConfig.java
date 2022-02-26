package com.randomhouse.bookstore.configurations;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@Slf4j
public class PasswordEncoderConfig {

    @Bean
    @ConditionalOnProperty(prefix = "passwordencoder", name="name",havingValue = "bcrypt")
    public PasswordEncoder bcrypt(){
        log.info("Password encoder used is Bcrypt");

        return new BCryptPasswordEncoder(12);

    }

}
