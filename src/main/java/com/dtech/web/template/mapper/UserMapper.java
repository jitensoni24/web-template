package com.dtech.web.template.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.dtech.web.template.entity.User;
import com.dtech.web.template.resource.UserResource;

import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MappingContext;

@Component
public class UserMapper extends CustomMapper<User, UserResource> {
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public void mapAtoB(User user, UserResource resource, MappingContext context) {
		super.mapAtoB(user, resource, context);
		resource.setPassword(null);
	}
	
	@Override
	public void mapBtoA(UserResource resource, User user, MappingContext context) {
		if(resource.getPassword() != null) {
			System.out.println(resource.getPassword());
			user.setPassword(passwordEncoder.encode(resource.getPassword()));
			System.out.println(user.getPassword());
		}
	}
}
