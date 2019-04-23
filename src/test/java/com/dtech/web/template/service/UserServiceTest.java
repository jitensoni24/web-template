package com.dtech.web.template.service;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;

import com.dtech.web.template.resource.UserResource;
import com.github.javafaker.Faker;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

	private Faker faker = new Faker();
	
	@Mock
	private RestTemplate restTemplate;
	
	@InjectMocks
	private UserService userService = new UserService();
	
	@Before
	public void setup() {
	    ReflectionTestUtils.setField(userService, "url", "http://someurl");
	} 
	
	@Test
	public void should_ReturnUser() throws Exception {
		//given
		UserResource resource = new UserResource();
		resource.setActive(true);
		resource.setEmail(faker.internet().emailAddress());
		resource.setPassword(faker.lorem().fixedString(4));
		resource.setUsername(faker.name().username());
		
		ResponseEntity<UserResource> responseEntity =
				ResponseEntity.status(HttpStatus.OK).body(resource);
		
		//when
		when(restTemplate.exchange("http://someurl" + "/1" , HttpMethod.GET, null, UserResource.class)).thenReturn(responseEntity);
		
		UserResource user = userService.get(1L);
		
		//then
		assertNotNull(user);
		assertThat(resource.getUsername(), equalTo(user.getUsername()));
		
		//verify
		verify(restTemplate, times(1)).exchange("http://someurl" + "/1" , HttpMethod.GET, null, UserResource.class);
		
	}
}
