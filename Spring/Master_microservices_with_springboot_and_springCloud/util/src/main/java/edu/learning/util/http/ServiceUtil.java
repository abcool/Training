package edu.learning.util.http;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Objects;

@Component
public class ServiceUtil {
    private static final Logger log = LogManager.getLogger(ServiceUtil.class);
    private final String port;
    private String serviceAddress;

    public ServiceUtil(@Value("${server.port}") String port){
        this.port=port;
    }

    public String getServiceAddress(){
        if(Objects.isNull(serviceAddress)){
            this.serviceAddress = findMyHostName() + "/" + findMyIpAddress() + ":" + port;
        }
        return serviceAddress;
    }

    private String findMyIpAddress() {
        try {
            return InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            log.error("Error occured. Unable to fetch IPAddress");
            return "Unknown IP Address";
        }
    }

    private String findMyHostName() {
        try {
            return InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            log.error(" Error occured. Unable to fetch hostname.");
            return "Unknown host";
        }
    }
}
