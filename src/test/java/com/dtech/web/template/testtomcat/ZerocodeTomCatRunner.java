package com.dtech.web.template.testtomcat;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.jsmart.zerocode.core.runner.ZeroCodeUnitRunner;
import org.junit.runners.model.InitializationError;

public class ZerocodeTomCatRunner  extends ZeroCodeUnitRunner {
    private static final int PORT = 8080;
    private static final String CONTEXT = "/web-template";
    private static Tomcat tomcat;

    public ZerocodeTomCatRunner(Class<?> klass) throws InitializationError {
        super(klass);
        startWebApp();
    }

    private void startWebApp() {
        tomcat = TomcatWebServer.createWebAAppWith(PORT, CONTEXT);
        try {
            tomcat.start();
        } catch (LifecycleException e) {
            throw new RuntimeException(e);
        }
    }
}
