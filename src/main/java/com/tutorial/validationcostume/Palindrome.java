package com.tutorial.validationcostume;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PalindromeValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.ANNOTATION_TYPE, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Palindrome {

    String message() default "{Palindrome.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
