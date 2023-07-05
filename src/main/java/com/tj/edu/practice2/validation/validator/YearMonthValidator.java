package com.tj.edu.practice2.validation.validator;

import com.tj.edu.practice2.validation.annotation.YearMonth;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class YearMonthValidator implements ConstraintValidator<YearMonth, String>{

    private String pattern;

    @Override
    public void initialize(YearMonth constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);

        this.pattern = constraintAnnotation.pattern();
    }


    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        //YYYYMM
        try {
            LocalDate.parse(value + "01", DateTimeFormatter.ofPattern(this.pattern));
        } catch (Exception e) {
            return false;
        }

        return true;
    }

}
