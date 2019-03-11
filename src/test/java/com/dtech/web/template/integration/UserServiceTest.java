package com.dtech.web.template.integration;

import static org.springframework.test.web.client.ExpectedCount.once;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withStatus;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.test.web.client.response.DefaultResponseCreator;
import org.springframework.web.client.RestTemplate;

import com.dtech.web.template.config.ApplicationConfig;
import com.dtech.web.template.resource.UserResource;
import com.dtech.web.template.service.UserService;
import com.google.common.io.Resources;

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
        //what will json response look like (i.e http get/post, body, contenttype etc), use responsecreator to define that
		DefaultResponseCreator response = withStatus(HttpStatus.OK)
											.body(getResourceAsString("content/users.json").getBytes())
											.contentType(MediaType.APPLICATION_JSON_UTF8);
		
        mockRestServer.expect(once(), requestTo(url)).andRespond(response);

        
        List<UserResource> result = userService.get();
        result.forEach(System.out::println);

        
        //finally verify 
        mockRestServer.verify();
    }

	private String getResourceAsString(String contentPath) {
		try {
			
			return IOUtils.toString(Resources.getResource(contentPath), StandardCharsets.UTF_8);
			
		} catch (IOException e) {}
		return null;
	}

}
