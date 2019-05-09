package com.dtech.web.template.service;

import com.dtech.web.template.resource.UserResource;
import org.springframework.stereotype.Service;

@Service
public class SimpleUserService {

    public UserResource getSimpleUser(String username) {
        UserResource userResource = new UserResource();
        userResource.setUsername(username);
        userResource.setActive(true);
        userResource.setEmail("abc@gmail.com");
        return userResource;
    }

    public UserResource createSimpleUser(UserResource userResource) {
        return userResource;
    }
}
