package com.unity.authentication.manager.common.verification.validator;

import com.unity.authentication.manager.common.verification.annotation.UserIdsSize;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UserIdsValidator implements ConstraintValidator<UserIdsSize, String> {
    private UserIdsSize annotation;

    public void initialize(UserIdsSize annotation) {
        this.annotation = annotation;
    }

    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (StringUtils.isEmpty(value)) {
            return annotation.acceptNull();
        }
        return value.split(annotation.separator()).length <= annotation.max();
    }
}
