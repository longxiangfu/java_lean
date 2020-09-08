package com.lxf.web.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class SubValidVo {

    @NotNull
    private Integer id;
}
