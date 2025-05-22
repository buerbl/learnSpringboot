package com.example.lsbinterceptor.config;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)  // 注解作用在方法上
@Retention(RetentionPolicy.RUNTIME)
public @interface Log {
    String value() default "";
}
