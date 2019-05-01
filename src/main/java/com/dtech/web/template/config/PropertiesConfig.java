package com.dtech.web.template.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.dtech.web.template.environment.Local;

//@All
@Configuration
public class PropertiesConfig {
    @Local
    @Configuration
    @PropertySource(value = {
            "classpath:/env/local/application.properties",
            "classpath:/env/local/persistence.properties"
    }, ignoreResourceNotFound = true)
    static class LocalProperties {
    }
}