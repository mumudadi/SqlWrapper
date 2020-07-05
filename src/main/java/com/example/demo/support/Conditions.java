package com.example.demo.support;

import java.lang.annotation.*;

/**
 * @author ljd
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Conditions {
    SqlKeywords value() default SqlKeywords.EQUAL;
}
