package com.example;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by administrator on 17/2/17.
 *
 * http://www.cnblogs.com/peida/archive/2013/04/24/3036689.html
 */
@Retention(RetentionPolicy.CLASS)
@Target(ElementType.TYPE)

public @interface MyAnnotation {
    public String preName() default "";

    public String lastName() default "";
}
