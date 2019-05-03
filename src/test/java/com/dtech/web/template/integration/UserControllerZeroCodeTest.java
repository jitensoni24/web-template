package com.dtech.web.template.integration;

import com.dtech.web.template.testtomcat.TomcatWebServer;
import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import org.jsmart.zerocode.core.domain.JsonTestCase;
import org.jsmart.zerocode.core.domain.TargetEnv;
import org.jsmart.zerocode.core.runner.ZeroCodeUnitRunner;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.transaction.annotation.Transactional;

@TargetEnv("local-host.properties")
@RunWith(ZeroCodeUnitRunner.class)
@Transactional
public class UserControllerZeroCodeTest {
    private static final int PORT = 8080;
    private static final String CONTEXT = "/web-template";
    private static Tomcat tomcat;

    @BeforeClass
    public static void beforeAll() throws LifecycleException, ServletException, IOException {
        tomcat = TomcatWebServer.createWebAAppWith(PORT, CONTEXT);
        tomcat.start();
    }

    @AfterClass
    public static void afterAll() throws LifecycleException, ServletException, IOException {
        tomcat.stop();
    }

    @Test
    @JsonTestCase("content/user_get.json")
    public void get_user1() throws Exception {
    }

    @Test
    @JsonTestCase("content/user_create_and_get.json")
    public void get_user2() throws Exception {
    }

}
