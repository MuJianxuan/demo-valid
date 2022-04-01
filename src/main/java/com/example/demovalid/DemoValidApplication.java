package com.example.demovalid;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.HibernateValidator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

@Slf4j
@SpringBootApplication
public class DemoValidApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(DemoValidApplication.class, args);
    }

    @Bean
    public Validator validator() {
        ValidatorFactory validatorFactory = Validation.byProvider(HibernateValidator.class)
                .configure()
                // 快速失败模式
                .failFast(true)
                .buildValidatorFactory();
        return validatorFactory.getValidator();
    }

    /**
     * 会是一个 dev,uat
     */
    @Value("${spring.profiles.active:dev}")
    private String env;

    @Override
    public void run(String... args) throws Exception {
        log.info("env:{}",env);
    }
}
