package com.dtech.web.template.controller;

import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.dtech.web.template.exception.InvalidArgumentException;
import com.dtech.web.template.resource.UserResource;
import com.dtech.web.template.service.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private MessageSource messageSource;

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<UserResource> get() {
        return userService.get();
    }
        
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/whoami", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public UserResource whoAmI() {
        return userService.whoAmI();
    }
    
    //TODO fix this method
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public UserResource get(@PathVariable Long id) {
        System.out.println(messageSource.getMessage("user.greeting.msg", new Long[] {id}, Locale.getDefault()));
        
        UserResource userResource = userService.get(id);
        
		return userResource;
    }
    
    //TODO fix this method 
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/name/{username}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public UserResource get(@PathVariable String username) {
        System.out.println(messageSource.getMessage("user.greeting.msg", new String[] {username}, Locale.getDefault()));
        
        UserResource userResource = userService.get(username);
        
		return userResource;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public UserResource create(@Valid @RequestBody UserResource userResource) {
        return userService.create(userResource);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public UserResource update(@PathVariable Long id,@Valid @RequestBody UserResource userResource) {
        return userService.update(id, userResource);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void delete(@PathVariable Long id) {
        throw new InvalidArgumentException("invalid.argument", "id", id);
    }
}
