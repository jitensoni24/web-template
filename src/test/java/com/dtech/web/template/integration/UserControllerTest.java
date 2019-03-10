package com.dtech.web.template.integration;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dtech.web.template.config.ApplicationConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationConfig.class})
@PropertySource(value="classpath:test-application.properties")
public class UserControllerTest {
    
    
    
    @Test
    public void testGetAll() throws Exception {
        
    }
        
    @Test
    public void testWhoAmI() throws Exception {
        
    }
    
    
    @Test
    public void testGet() throws Exception {
        
    }

    @Test
    public void testCreate() throws Exception {
        
    }

    @Test
    public void testUpdate() throws Exception  {
        
    }

    @Test
    public void testDelete() throws Exception  {
        
    }
}
