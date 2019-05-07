package com.example.demo.annotation;

import java.lang.annotation.*;

/**
 * @author pangkun
 * @date 2019/5/7 上午7:26
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Validator {
    String value() default "";
}
