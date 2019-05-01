package com.dtech.web.template.environment;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Profile;

@Profile("local")
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Local {}
