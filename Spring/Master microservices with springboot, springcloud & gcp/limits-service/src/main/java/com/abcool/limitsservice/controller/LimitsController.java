package com.abcool.limitsservice.controller;

import com.abcool.limitsservice.beans.Limits;
import com.abcool.limitsservice.config.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsController {

    @Autowired
    private Configuration configuration;

    @GetMapping(path="/limits")
    public Limits retrieveLimits(){
        return new Limits(configuration.getMin(),configuration.getMax());
        //return new Limits(1,500);
    }
}
