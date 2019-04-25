package com.dtech.web.template.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.dtech.web.template.builder.UserFactory;
import com.dtech.web.template.resource.UserResource;
import com.dtech.web.template.service.UserService;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {
    
	@Mock
	private UserService userService;
	
	@InjectMocks
	private UserController userController;
	
	@Before 
	public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }
	
	@Test
    public void should_return_all_users() throws Exception {
        //given
    	List<UserResource> expectedUserResources = UserFactory.userResources();
        when(userService.get()).thenReturn(expectedUserResources);
    	
    	//when
    	List<UserResource> users = userController.get();
    	
    	//then
    	assertNotNull(users);
    	assertEquals(2, users.size());
    	
    	//verify
    	verify(userService, times(1)).get();
    }
    
    public void should_return_user(Long userId) throws Exception {
        
    }

    public void should_return_user_not_found(Long userId) throws Exception {
        
    }

    public void testWhoAmI() throws Exception {
        
    }

    public void testCreate() throws Exception {
        
    }

    public void testUpdate() throws Exception  {
        
    }

    public void testDelete() throws Exception  {
        
    }
}
