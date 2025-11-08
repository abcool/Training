package com.abcool.currencyconversionservice.externalServices;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;

//@FeignClient(name = "CURRENCY-EXCHANGE-SERVICE",url = "${CURRENCY_EXCHANGE_SERVICE_SERVICE_HOST:http://localhost}:8000")
@FeignClient(name = "CURRENCY-EXCHANGE-SERVICE",url = "${CURRENCY_EXCHANGE_URI:http://localhost}:8000")
public interface CurrencyExchangeServiceInterface {

    @GetMapping(path = "currency-exchange/from/{from}/to/{to}")
    public Object getConversionMultiple(@PathVariable String from, @PathVariable String to);
}
