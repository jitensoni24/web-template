package com.dtech.web.template.integration;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import com.dtech.web.template.config.ApplicationConfig;
import com.google.common.io.Resources;

@ActiveProfiles("unit-test")
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { ApplicationConfig.class })
@Transactional
public abstract class IntegrationTest {

	@PersistenceContext
	protected EntityManager em;

	protected MockMvc mockMvc;

	@Autowired
	private WebApplicationContext context;

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	protected String getResourceAsString(String url) throws IOException {
		return Resources.toString(Resources.getResource(url), StandardCharsets.UTF_8);
	}
}
