package com.dtech.web.template.controller;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(MockitoJUnitRunner.class)
public class PingControllerTest {

    private MockMvc mockMvc;
    
    @InjectMocks
    private PingController pingController;

    @Before
    public void setUp() throws IOException {
        ReflectionTestUtils.setField(pingController, "projectVersion", "1.0");
        ReflectionTestUtils.setField(pingController, "hostAddress", "localhost");
        
        mockMvc = MockMvcBuilders.standaloneSetup(pingController).build();
    }
    
    @Test
    public void testHome() throws Exception {
        mockMvc.perform(get("/"))
        .andDo(print())
        .andExpect(jsonPath("$.ping", equalTo("http://localhost:8080/ping")))
        .andExpect(jsonPath("$.version", equalTo("http://localhost:8080/version")))
        .andExpect(status().isOk())
        ;
    }
    
    @Test
    public void testPing() throws Exception {
        mockMvc.perform(get("/ping"))
        .andDo(print())
        .andExpect(status().isOk())
        ;
    }
    
    @Test
    public void testVersion() throws Exception {
        mockMvc.perform(get("/version"))
        .andDo(print())
        .andExpect(jsonPath("$.version", equalTo("1.0")))
        .andExpect(status().isOk())
        ;
    }

}
