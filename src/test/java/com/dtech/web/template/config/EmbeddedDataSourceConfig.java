package com.dtech.web.template.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import com.dtech.web.template.environment.UnitTest;

@UnitTest
@Configuration
public class EmbeddedDataSourceConfig {
    @Bean
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder()
        		.setType(EmbeddedDatabaseType.HSQL)
        		.addScripts("classpath:schema.sql")
        		.build();
    }
}