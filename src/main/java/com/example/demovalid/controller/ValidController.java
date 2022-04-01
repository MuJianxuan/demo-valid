package com.example.demovalid.controller;

import com.example.demovalid.entitiy.TestEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validator;
import java.util.Set;
import java.util.stream.Collectors;


/**
 * desc: 测试
 *
 * @author Rao
 * @Date 2022/03/02
 **/
@Validated
@Slf4j
@RestController
@RequestMapping("valid")
public class ValidController {

    @Autowired
    private Validator validator;

    @PostMapping
    public String validTest(@Valid @RequestBody TestEntity testEntity){
        log.info(" validTest : {}",testEntity);
        Set<ConstraintViolation<TestEntity>> validate = validator.validate(testEntity);
        return validate.stream().map(ConstraintViolation::getMessage).collect(Collectors.joining(","));
    }
}

