package com.dtech.web.template.integration;

import org.jsmart.zerocode.core.domain.JsonTestCase;
import org.jsmart.zerocode.core.domain.TargetEnv;
import org.jsmart.zerocode.core.runner.ZeroCodeUnitRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.transaction.annotation.Transactional;

@TargetEnv("local-host.properties")
@RunWith(ZeroCodeUnitRunner.class)
@Transactional
public class UserControllerTestZeroCode {
	
	@Test
    @JsonTestCase("content/user_get.json")
    public void get_user() throws Exception {}
	
	@Test
    @JsonTestCase("content/user_create.json")
    public void create_user() throws Exception {}
}
