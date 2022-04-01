package com.example.demovalid.entitiy;

import com.example.demovalid.ano.Phone;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * desc:
 *
 * @author Rao
 * @Date 2022/03/02
 **/
@Data
public class TestEntity implements Serializable {
    private static final long serialVersionUID = -8518757578199967051L;

    public interface Update {

    }

    public interface Insert {

    }

    @Phone(message = "手机号格式不正确！")
    private String phone;

    @Email(message = "邮箱格式不正确！")
    private String mail;

    @NotNull(message = "name 学习不为空！",groups = {TestEntity.Update.class})
    @Length(min = 1,max = 20)
    private String name;

    @NotNull(message = "age 不能为空！",groups = {TestEntity.Insert.class})
    @Max(value = 100,message = "你超过100岁了")
    private Integer age;

//    @Valid
//    @NotNull(message = "xxxxx",groups = {TestEntity.Update.class})
//    private Bss bss;
//
//    @Valid
//    @NotNull(message = "assEntity 不为空")
//    private AssEntity assEntity;


    @Data
    private static class Bss {

        @NotNull(message = "age 不能为空！")
        @Max(value = 100,message = "你超过100岁了")
        private Integer age;

    }


}
