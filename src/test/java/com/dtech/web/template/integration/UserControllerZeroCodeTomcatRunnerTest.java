package com.dtech.web.template.integration;

import com.dtech.web.template.testtomcat.TomcatWebServer;
import com.dtech.web.template.testtomcat.ZerocodeTomCatRunner;
import java.io.IOException;
import javax.servlet.ServletException;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.jsmart.zerocode.core.domain.JsonTestCase;
import org.jsmart.zerocode.core.domain.TargetEnv;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.transaction.annotation.Transactional;

@TargetEnv("local-host.properties")
@RunWith(ZerocodeTomCatRunner.class)
@Transactional
public class UserControllerZeroCodeTomcatRunnerTest {

    @Test
    @JsonTestCase("content/user_get.json")
    public void get_user() throws Exception {
    }

    @Test
    @JsonTestCase("content/user_create_and_get.json")
    public void post_n_get_user() throws Exception {
    }

}
