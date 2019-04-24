package com.dtech.web.template.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.dtech.web.template.environment.UnitTest;

@UnitTest
@Configuration
@PropertySource({
    "classpath:/env/unit-test/application.properties",
    "classpath:/env/unit-test/persistence.properties"
})
public class TestPropertiesConfig {}
