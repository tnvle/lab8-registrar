package edu.mum.cs.cs425.eRegistrar.model.validators;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;


@Target({ElementType.TYPE,ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueStudentNumberValidator.class)
public @interface UniqueStudentNumber {
	String message() default "{edu.mum.cs.cs425.eregistrar.customvalidators.uniquestudentnumber.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
