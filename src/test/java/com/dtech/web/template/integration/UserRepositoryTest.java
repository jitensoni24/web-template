package com.dtech.web.template.integration;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.dtech.web.template.builder.UserFactory;
import com.dtech.web.template.entity.User;
import com.dtech.web.template.repository.UserRepository;

public class UserRepositoryTest extends IntegrationTest {

	@Autowired
	UserRepository userRepository;
	
	@Test
	public void getUser() throws Exception {
		User user = UserFactory.user();
		
		em.persist(user);
		
		List<User> list = userRepository.get();
		
		list.forEach(System.out::print);
	}
}
