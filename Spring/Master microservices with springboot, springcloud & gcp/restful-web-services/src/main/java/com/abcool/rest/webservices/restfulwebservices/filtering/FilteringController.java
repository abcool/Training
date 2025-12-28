package com.abcool.rest.webservices.restfulwebservices.filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {

    /*@GetMapping(path="/filtering-list")
    public List<SomeBean> someBeans(){
        return Arrays.asList(new SomeBean("value1","value2","value3"), new SomeBean("value4","vaue5","value6"));
    }*/
    @GetMapping(path="/filtering-list-dynamic")
    public MappingJacksonValue someBeans(){
        List<SomeBean> someBeans = Arrays.asList(new SomeBean("value1","value2","value3"), new SomeBean("value4","value5","value6"));
        SimpleBeanPropertyFilter filterCriteria = SimpleBeanPropertyFilter.filterOutAllExcept("value1","value2");
        FilterProvider filterProvider = new SimpleFilterProvider().addFilter("MyFilter",filterCriteria);
        MappingJacksonValue mappingValues = new MappingJacksonValue(someBeans);
        mappingValues.setFilters(filterProvider);
        return mappingValues;
    }
    @GetMapping(path="/filtering-bean-dynamic")
    public MappingJacksonValue someBean(){
        SomeBean someBean = new SomeBean("value1","value2","value3");
        SimpleBeanPropertyFilter filterCriteria = SimpleBeanPropertyFilter.filterOutAllExcept("value2","value3");
        FilterProvider filterProvider = new SimpleFilterProvider().addFilter("MyFilter",filterCriteria);
        MappingJacksonValue mappingValues = new MappingJacksonValue(someBean);
        mappingValues.setFilters(filterProvider);
        return mappingValues;
    }
}
