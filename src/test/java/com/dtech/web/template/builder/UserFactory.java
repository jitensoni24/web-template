package com.dtech.web.template.builder;

import java.util.ArrayList;
import java.util.List;

import com.dtech.web.template.entity.User;
import com.dtech.web.template.resource.UserResource;
import com.github.javafaker.Faker;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserFactory {

	private static Faker faker = new Faker();
	
	public static User user() {
		User user = new User();

		user.setActive(true);
		user.setEmail(faker.internet().safeEmailAddress());
		user.setUsername(faker.name().username());
		user.setPassword(faker.internet().password());
		
		return user;
	}
	
	public static List<User> users() {
		List<User> users = new ArrayList<User>();
		
		User user = new User();

		user.setActive(true);
		user.setEmail(faker.internet().safeEmailAddress());
		user.setUsername(faker.name().username());
		user.setPassword(faker.internet().password());
		users.add(user);
		
		user = new User();

		user.setActive(true);
		user.setEmail(faker.internet().safeEmailAddress());
		user.setUsername(faker.name().username());
		user.setPassword(faker.internet().password());
		users.add(user);
		
		return users;
	}
	
	public static UserResource userResource() {
		UserResource user = new UserResource();

		user.setActive(true);
		user.setEmail(faker.internet().safeEmailAddress());
		user.setUsername(faker.name().username());
		user.setPassword(null);
		
		return user;
	}
	
	public static List<UserResource> userResources() {
		List<UserResource> users = new ArrayList<UserResource>();
		
		UserResource user = new UserResource();

		user.setActive(true);
		user.setEmail(faker.internet().safeEmailAddress());
		user.setUsername(faker.name().username());
		user.setPassword(null);
		users.add(user);
		
		user = new UserResource();

		user.setActive(true);
		user.setEmail(faker.internet().safeEmailAddress());
		user.setUsername(faker.name().username());
		user.setPassword(null);
		users.add(user);
		
		return users;
	}

}
