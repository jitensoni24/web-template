package com.dtech.web.template.config;

import javax.sql.DataSource;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.dtech.web.template.environment.Local;

@Local
@Configuration
public class FlywayConfig {

	@Autowired
	private DataSource ds;

	@Bean
	public Flyway flyway() {
		Flyway flyway = new Flyway();
		flyway.setBaselineOnMigrate(true);
		flyway.setLocations("classpath:/migrations");
		flyway.setDataSource(ds);

		// flyway.repair();

		// flyway.migrate();

		return flyway;
	}

}