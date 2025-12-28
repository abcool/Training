package edu.learning.EazyBankApplication.util;

import org.apache.logging.log4j.*;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.util.Optional;
@Component
public class ServerUtil {
    private final Logger LOGGER = LogManager.getLogger(ServerUtil.class);
    public Optional<String> serverName(){
        String serverName="";
        String serverPort = Optional.ofNullable(System.getenv("PORT"))
                .orElse(System.getProperty("server.port", "8080"));
        try {
            serverName = InetAddress.getLocalHost().getHostName();
        }catch (Exception ex){
            LOGGER.error("Error while getting server name", ex);
        }
        return Optional.of(serverName+":"+serverPort);
    }
}
