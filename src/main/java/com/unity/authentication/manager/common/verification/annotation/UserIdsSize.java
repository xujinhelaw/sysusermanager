package com.unity.authentication.manager.common.verification.annotation;

import com.unity.authentication.manager.common.verification.validator.UserIdsValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UserIdsValidator.class)
public @interface UserIdsSize {
    boolean acceptNull() default true;

    int max() default 1;

    String separator() default ",";

    String message() default "";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
