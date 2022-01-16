package com.dtech.web.template.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
public class PropertiesConfigTest {

    @com.dtech.web.template.environment.Test
    @PropertySource(value = "classpath:application-test.properties")
    public static class Test {}

}
