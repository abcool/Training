package edu.learning.util.http;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Component
public class ServiceUtility {
    private static final Logger log = LogManager.getLogger(ServiceUtility.class);
    private final String port;
    private String serviceAddress ="";

    @Autowired
    public ServiceUtility(@Value("${server.port}") String port) {
        this.port = port;
    }

    public String getServiceAddress() {
        return serviceAddress==""?findMyHostname() + "/" + findMyIpAddress() + ":" + port:serviceAddress;
    }

    private String findMyHostname(){
        try {
            return InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            return "unknown host exception";
        }
    }
    private String findMyIpAddress(){
        try {
            return InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            return "unknown IPAddress";
        }
    }
}
