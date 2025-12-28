package com.abcool.rest.webservices.restfulwebservices.helloWorld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	@Autowired
	private MessageSource messageSource;
	
    @GetMapping(path="/hello")
    public String helloWorld(){
        return "Hello World";
    }
    
    @GetMapping(path="/hello-bean")
    public HelloWorldBean helloWorldBean(){
        return new HelloWorldBean("Hello World");
    }
    
    /*@GetMapping(path="/hello-international")
    public String helloWorldInternational(@RequestHeader(name="Accept-Language",required=false) Locale locale){
        return messageSource.getMessage("good.morning.message", null, locale);
    }*/
    
    @GetMapping(path="/hello-international")
    public String helloWorldInternational(){
        return messageSource.getMessage("good.morning.message", null, LocaleContextHolder.getLocale());
    }

}
