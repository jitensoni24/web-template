package com.dtech.web.template.controller;

import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingController {
    
    @Value("${project.version}")
    private String projectVersion;

    private String hostAddress;
    
    @RequestMapping(path = "/", method=RequestMethod.GET)
    @ResponseBody
    public Map<String, String> home(HttpServletRequest request) throws Exception {
        String path = request.getContextPath();
        Map<String, String> version = new HashMap<>();
        version.put("ping", String.format("http://%s:8080%s/ping", getHostAddress(), path));
        version.put("version", String.format("http://%s:8080%s/version", getHostAddress(), path));
        
        return version;
    }
    
    @RequestMapping(path = "/ping")
    public void proxy(HttpServletResponse servletResponse) throws IOException {
       StringBuilder builder = new StringBuilder();
        builder.append("<html>");
        builder.append("\n  <head>");
        builder.append("\n    <title>Web Template - 1</title>");
        builder.append("\n  </head>");
        builder.append("\n  <body>");
        builder.append("\n    " + projectVersion );
        builder.append("\n  </body>");
        builder.append("\n</html>");

        servletResponse.getWriter().println(builder.toString());
    }
    
    @RequestMapping(path = "/version", method=RequestMethod.GET)
    @ResponseBody
    public Map<String, String> version() throws Exception {
        Map<String, String> version = new HashMap<>();
        version.put("version", projectVersion);
        
        return version;
    }
    
    private String getHostAddress() {
        if (hostAddress == null) {
            try {
                hostAddress = InetAddress.getLocalHost().getHostName();

                Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();

                while (networkInterfaces.hasMoreElements()) {
                    NetworkInterface networkInterface = networkInterfaces.nextElement();

                    Enumeration<InetAddress> inetAddresses = networkInterface.getInetAddresses();
                    while (inetAddresses.hasMoreElements()) {
                        InetAddress inetAddress = inetAddresses.nextElement();
                        hostAddress = inetAddress.getHostAddress();
                    }
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        return hostAddress;
    }
}
