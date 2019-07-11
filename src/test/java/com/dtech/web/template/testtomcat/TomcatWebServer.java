package com.dtech.web.template.testtomcat;

import java.io.File;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;

public class TomcatWebServer {

    public static Tomcat createWebAAppWith(int port, String context) {
        String webAppDirLocation = "src/main/";
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(port);
        try {
            StandardContext ctx = (StandardContext) tomcat.addWebapp(context, new File(webAppDirLocation).getAbsolutePath());
            tomcat.start();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return tomcat;
    }
}
