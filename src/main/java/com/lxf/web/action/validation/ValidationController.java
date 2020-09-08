package com.lxf.web.action.validation;

import com.lxf.web.vo.ValidVo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import javax.validation.Validator;
import javax.validation.constraints.NotNull;

/**
 * 测试参数校验
 */
@RestController
@RequestMapping("/valid")
public class ValidationController {

    /**
     * 嵌套校验、集合校验、自定义校验
     */
    @PostMapping("/nesting")
    public void nestingValid(@RequestBody @NotNull @Valid ValidVo validVo){
        System.out.println("校验");

    }
}
