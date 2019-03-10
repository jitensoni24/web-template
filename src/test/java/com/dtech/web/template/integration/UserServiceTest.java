package com.dtech.web.template.integration;

import static org.springframework.test.web.client.ExpectedCount.once;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

import com.dtech.web.template.config.ApplicationConfig;
import com.dtech.web.template.resource.UserResource;
import com.dtech.web.template.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ApplicationConfig.class })
@PropertySource(value = "classpath:test-application.properties")
@WebAppConfiguration
public class UserServiceTest {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    UserService userService;

    MockRestServiceServer mockRestServer;

    @Value("${users.url}")
    private String url;

    @Before
    public void init() throws Exception {
        mockRestServer = MockRestServiceServer.createServer(restTemplate);
    }

    @Test
    public void testGetAll() throws Exception {
        System.out.println("get all users test");

        //create the expectation and response of mock rest service server
        mockRestServer.expect(once(), requestTo(url))
        .andRespond(withSuccess("{message : 'under construction'}", MediaType.APPLICATION_JSON));

        List<UserResource> result = userService.get();
        System.out.println("results: : " + result);

        //finally verify to run the mrss 
    }

}
