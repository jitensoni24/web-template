package com.dtech.web.template.builder;

import com.dtech.web.template.entity.User;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserFactory {

	public static User user() {
		User user = new User();

		user.setActive(true);
		user.setEmail("test@test.com");
		user.setUsername("test");
		user.setPassword("test1234");
		
		return user;
	}

}
