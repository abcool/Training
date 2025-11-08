package com.abcool.rest.webservices.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    //Versioning using path param/request parameter
    @GetMapping(path="/person",params = "v1")
    public PersonV1 paramV1(){
        return new PersonV1("Sonia Sharma");
    }

    @GetMapping(path = "/person",params = "v2")
    public PersonV2 paramV2(){
        return new PersonV2(new Name("Sonia","Sharma"));
    }
    //Versioning using headers
    @GetMapping(path="/person",headers = "X-API-VERSION=1")
    public PersonV1 headerV1(){
        return new PersonV1("Sonia Sharma");
    }

    @GetMapping(path = "/person",headers = "X-API-VERSION=2")
    public PersonV2 headerV2(){
        return new PersonV2(new Name("Sonia","Sharma"));
    }
    //Versioning using mime type/ Accept-header
    @GetMapping(path="/person",produces = "application/funcompany.app-v1+json")
    public PersonV1 producesV1(){
        return new PersonV1("Sonia Sharma");
    }

    @GetMapping(path = "/person",produces = "application/funcompany.app-v2+json")
    public PersonV2 producesV2(){
        return new PersonV2(new Name("Sonia","Sharma"));
    }
}
