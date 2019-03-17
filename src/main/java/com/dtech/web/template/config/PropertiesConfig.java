package com.dtech.web.template.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
public class PropertiesConfig {

    @com.dtech.web.template.environment.Local
    @PropertySource(value = "classpath:application-local.properties")
    public static class Local {}

    @com.dtech.web.template.environment.Prod
    @PropertySource(value = "classpath:application-prod.properties")
    public static class Prod {}
}
