package com.abcool.rest.webservices.restfulwebservices.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	
	public static final Contact DEFAULT_CONTACT
    = new Contact(
    "Abcool",
    "learning-made-fun.com",
    "abcool@learning-made-fun.com");
public static final ApiInfo DEFAULT_API_INFO
    = new ApiInfo(
    "My API",
    "My API Docs",
    "1.0",
    "urn:tos",
    DEFAULT_CONTACT,
    "Apache 2.0",
    "http://www.apache.org/licenses/LICENSE-2.0",
    new ArrayList<>());
private static final Set<String> DEFAULT_PRODUCES_CONSUMES = new HashSet<>(Arrays.asList("application/json","application/xml"));
	

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(DEFAULT_API_INFO)
				.produces(DEFAULT_PRODUCES_CONSUMES)
				.consumes(DEFAULT_PRODUCES_CONSUMES);
	}

}
