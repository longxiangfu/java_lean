package com.lxf.web.vo;

import com.lxf.annotation.valid.EncryptId;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class ValidVo {

    @NotNull
    private Integer id;

    @NotBlank
    @EncryptId
    private String valid1;

    private String valid2;

    /*
    嵌套校验
     */
    @Valid
    @NotNull
    private SubValidVo subValidVo;

    /*
    集合校验
     */
    @Valid
    @NotEmpty
    private List<SubValidVo> list;
}
