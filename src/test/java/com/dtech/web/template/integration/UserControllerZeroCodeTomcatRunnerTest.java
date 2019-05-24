package com.dtech.web.template.integration;

import org.jsmart.zerocode.core.domain.JsonTestCase;
import org.jsmart.zerocode.core.domain.TargetEnv;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.transaction.annotation.Transactional;

import com.dtech.web.template.testtomcat.ZerocodeTomCatRunner;

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
