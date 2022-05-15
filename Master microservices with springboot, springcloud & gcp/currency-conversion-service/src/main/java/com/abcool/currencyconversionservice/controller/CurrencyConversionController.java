package com.abcool.currencyconversionservice.controller;

import com.abcool.currencyconversionservice.beans.CurrencyConversion;
import com.abcool.currencyconversionservice.externalServices.CurrencyExchangeServiceInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.math.BigDecimal;
import java.util.LinkedHashMap;


@RestController
public class CurrencyConversionController {

    private static final Logger logger = LoggerFactory.getLogger(CurrencyConversionController.class);

    @Autowired
    CurrencyExchangeServiceInterface currencyExchangeServiceInterface;

    @GetMapping(path = "/currency-conversion/from/{from}/to/{to}/quantity/{qty}/")
    public CurrencyConversion calculateCurrencyConversion(@PathVariable String from, @PathVariable String to,
                                                          @PathVariable Integer qty) throws NoSuchFieldException, IllegalAccessException {
        logger.info("CurrencyConversion called with {} to {} with {}",from,to,qty);
        BigDecimal conversionMultiple = BigDecimal.valueOf(
                                        Double.parseDouble(
                                        getValueFromCurrencyExchangeService(from,to,"conversionMultiple")));
        String environment = getValueFromCurrencyExchangeService(from,to,"environment");
        Long id = Long.parseLong(getValueFromCurrencyExchangeService(from,to,"id"));
        BigDecimal total = conversionMultiple.multiply(BigDecimal.valueOf(qty));
        CurrencyConversion currencyConversion = new CurrencyConversion(id, from, to, conversionMultiple, qty,total);
        currencyConversion.setEnv(environment);
        return currencyConversion;
    }

    private String getValueFromCurrencyExchangeService(String from, String to, String key) {
        Object tempObj = currencyExchangeServiceInterface.getConversionMultiple(from, to);
        System.out.println("tempObj: " +tempObj.getClass());
        LinkedHashMap<Object,Object> map = ((LinkedHashMap<Object,Object>) tempObj);
        String value="";
        for(Object o:map.keySet()){
            if(o.toString().equals(key)){
                value = map.get(o).toString();
            }
        }
        return value;
    }
}
