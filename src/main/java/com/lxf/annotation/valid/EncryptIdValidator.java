package com.lxf.annotation.valid;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 自定义校验器
 */
public class EncryptIdValidator implements ConstraintValidator<EncryptId, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if ("valid".equals(value)) {
            return false;
        }
        return true;
    }
}
