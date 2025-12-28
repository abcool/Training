package edu.learning.EazyBankApplication.controller;

import edu.learning.EazyBankApplication.util.ServerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {
    private ServerUtil serverUtil;
    private static final String APPLICATION_UP="EazyBank Application is up and running";

    @Autowired
    public HealthCheckController(ServerUtil serverUtil) {
        this.serverUtil = serverUtil;
    }

    @GetMapping("/healthCheck")
    public ResponseEntity healthCheck() {
        String body = APPLICATION_UP + " on " + serverUtil.serverName().orElse("Unknown Server");
        return ResponseEntity.ok(body);
    }
}
