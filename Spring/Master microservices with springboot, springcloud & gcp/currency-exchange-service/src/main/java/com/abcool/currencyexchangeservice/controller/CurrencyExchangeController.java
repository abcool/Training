package com.abcool.currencyexchangeservice.controller;

import com.abcool.currencyexchangeservice.beans.CurrencyExchange;
import com.abcool.currencyexchangeservice.repository.CurrencyExchangeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Optional;

@RestController
public class CurrencyExchangeController {

    private static final Logger logger = LoggerFactory.getLogger(CurrencyExchangeController.class);

    @Autowired
    private Environment environment;

    @Autowired
    private CurrencyExchangeRepository currencyExchangeRepository;

    @GetMapping(path = "/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange retrieveExchangeValue(@PathVariable String from, @PathVariable String to){
        logger.info("Currency exchange service called to exchange {} to {}",from,to);
        //CurrencyExchange currencyExchange = new CurrencyExchange(100L, from, to, BigDecimal.valueOf(65.00));
        Optional<CurrencyExchange> currencyExchange = Optional.ofNullable(currencyExchangeRepository.findByFromAndTo(from,to));
        if(currencyExchange.isEmpty()){
            throw new RuntimeException("No exchange rate present for : "+ from + " to "+ to);
        }
        String port = environment.getProperty("local.server.port");
        //Kubernetes
        String host = environment.getProperty("HOSTNAME");
        String version = "v3";
        currencyExchange.get().setEnvironment(port + " "+ version + " "+ host);
        return currencyExchange.get();
    }
}
