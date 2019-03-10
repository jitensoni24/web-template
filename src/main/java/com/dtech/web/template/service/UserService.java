package com.dtech.web.template.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.dtech.web.template.exception.NotFoundException;
import com.dtech.web.template.resource.UserResource;
import com.github.javafaker.Faker;

@Service
public class UserService {
    
    Faker faker = new Faker();

    @Autowired
    private RestTemplate restTemplate;
 
    @Value("${users.url}")
    private String url;
    
    public List<UserResource> get() {
        ResponseEntity<List<UserResource>> user =
                restTemplate.exchange(url,
                            HttpMethod.GET, null, new ParameterizedTypeReference<List<UserResource>>() {
                    });
        
        return user.getStatusCode() == HttpStatus.OK ? user.getBody() : null;
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
