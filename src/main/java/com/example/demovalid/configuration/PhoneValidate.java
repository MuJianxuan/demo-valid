package com.example.demovalid.configuration;

import cn.hutool.core.util.PhoneUtil;
import com.example.demovalid.ano.Phone;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * desc: 手机号验证
 *
 * @author Rao
 * @Date 2022/03/14
 **/
public class PhoneValidate implements ConstraintValidator<Phone, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return PhoneUtil.isMobile( value);

    }
}
