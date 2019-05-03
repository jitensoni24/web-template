package com.dtech.web.template.controller;

import com.dtech.web.template.resource.UserResource;
import com.dtech.web.template.service.SimpleUserService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static java.lang.System.out;

@RestController
@RequestMapping(value = "/users")
public class SimpleUserController {
    
    @Autowired
    private SimpleUserService userService;
    
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/v1/name/{username}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public UserResource get(@PathVariable String username) {
        out.println("GET user.");
        return userService.getSimpleUser(username);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public UserResource create(@Valid @RequestBody UserResource userResource) {
        return userService.createSimpleUser(userResource);
    }
}
