package com.haiberg.automation.annotations;

import java.lang.annotation.ElementType;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)//The period is the runtime period
@Target({ElementType.METHOD })//can only used on the method
public @interface BeforeSuite {

}