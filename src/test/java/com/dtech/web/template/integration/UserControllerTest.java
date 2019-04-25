package com.dtech.web.template.integration;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.springframework.http.MediaType;

import com.dtech.web.template.builder.UserFactory;
import com.dtech.web.template.entity.User;

public class UserControllerTest extends IntegrationTest {

	@Test
	public void getUsers() throws Exception {
		User user = UserFactory.user();
		em.persist(user);

		mockMvc.perform(get("/users"))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));
	}

}
