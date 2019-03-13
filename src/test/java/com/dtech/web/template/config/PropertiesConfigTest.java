package com.dtech.web.template.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@Profile("test")
@Configuration
@PropertySource(value = "classpath:application-test.properties")
public class PropertiesConfigTest {

}
