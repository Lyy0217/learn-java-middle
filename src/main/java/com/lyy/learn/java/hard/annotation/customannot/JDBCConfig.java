package com.lyy.learn.java.hard.annotation.customannot;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;

/**
 *
 */
@Target({METHOD, TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
//@Repeatable(DBUtilAnot.class)
public @interface JDBCConfig {
    String ip();

    int port() default 3306;

    String database();

    String encoding();

    String loginName();

    String password();
}
