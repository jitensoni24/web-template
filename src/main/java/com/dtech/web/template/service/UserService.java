package com.dtech.web.template.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dtech.web.template.entity.User;
import com.dtech.web.template.exception.NotFoundException;
import com.dtech.web.template.mapper.BeanMapper;
import com.dtech.web.template.repository.UserRepository;
import com.dtech.web.template.resource.UserResource;

@Service
public class UserService {
    
    @Autowired
    private UserRepository repository;

    @Autowired
    private BeanMapper beanMapper;
    
    public List<UserResource> get() {
		
    	List<UserResource> users = beanMapper.mapAsList(repository.get(), UserResource.class);
		
		return users;
    }

    public UserResource get(Long id) {
		return beanMapper.map(repository.get(id), UserResource.class);
    }

    public UserResource get(String username) {
		return beanMapper.map(repository.get(username), UserResource.class);
    }

    public UserResource create(UserResource userResource) {
    	
    	User user = repository.create(beanMapper.map(userResource, User.class));
    	
		return beanMapper.map(user, UserResource.class);
    }

    public UserResource update(Long id, UserResource userResource) {
		return userResource;
    }

    public void delete(Long id) throws NotFoundException {
    }

    public UserResource whoAmI() {
           throw new RuntimeException("I don't know");
    }
}
