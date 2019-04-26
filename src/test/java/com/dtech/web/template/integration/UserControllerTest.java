package com.dtech.web.template.integration;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
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

	@Test
	public void createUsers() throws Exception {
		mockMvc.perform(post("/users")
				.content(getResourceAsString("content/user.json"))
				.contentType(MediaType.APPLICATION_JSON_VALUE))
			.andDo(print())
	        .andExpect(status().isCreated())
	        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
	        .andExpect(jsonPath("$.active", equalTo(true)))
	        .andExpect(jsonPath("$.username", equalTo("adriana.sporer")))
	        .andExpect(jsonPath("$.email", equalTo("delois.steuber@example.com")))
	        .andExpect(jsonPath("$.password").doesNotExist());
	}
}
