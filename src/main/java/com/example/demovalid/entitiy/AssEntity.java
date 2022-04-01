package com.example.demovalid.entitiy;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * desc:
 *
 * @author Rao
 * @Date 2022/03/03
 **/
@Data
public class AssEntity implements Serializable {

    private static final long serialVersionUID = 429888282377062548L;

    @NotNull(message = "xxxx")
    @Length(min = 1,max = 20)
    private String name;

}
