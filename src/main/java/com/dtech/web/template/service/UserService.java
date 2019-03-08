package com.dtech.web.template.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.dtech.web.template.exception.NotFoundException;
import com.dtech.web.template.resource.UserResource;
import com.github.javafaker.Faker;

@Service
public class UserService {
    
    Faker faker = new Faker();
    
    public List<UserResource> get() {
        UserResource userResource = new UserResource();
        userResource.setUsername(faker.name().firstName());
        return Arrays.asList(userResource);
    }

    public UserResource get(Long id) {
        UserResource userResource = new UserResource();
        userResource.setUsername(faker.name().firstName());
        return userResource;
    }

    public UserResource create(UserResource userResource) {
        userResource.setUsername(faker.name().firstName());
        return userResource;
    }

    public UserResource update(Long id, UserResource userResource) {
        userResource.setUsername(faker.name().firstName());
        return userResource;
    }

    public void delete(Long id) throws NotFoundException {
        throw new NotFoundException(faker.lorem().fixedString(20));
    }

    public UserResource whoAmI() {
           throw new RuntimeException("I don't know");
    }
}
