package com.example.demovalid.configuration;

import org.hibernate.validator.HibernateValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.validation.Validation;
import javax.validation.Validator;

/**
 * desc:
 *
 * @author Rao
 * @Date 2022/03/14
 **/
@Configuration
public class ValidConfiguration {

    @Bean
    @Primary
    public Validator validator(){
        return Validation.byProvider(HibernateValidator.class)
                .configure()
                // 快速失败模式
                .failFast(true)
                .buildValidatorFactory().getValidator();

    }

}
