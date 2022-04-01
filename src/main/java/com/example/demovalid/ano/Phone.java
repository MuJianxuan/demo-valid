package com.example.demovalid.ano;

import com.example.demovalid.configuration.PhoneValidate;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * desc: 手机号校验
 *
 * @author Rao
 * @Date 2022/03/14
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
@Documented
@Constraint(validatedBy = {PhoneValidate.class})
public @interface Phone {

    String message() default "Phone手机号码不正确！";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

}
