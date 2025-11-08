package com.abcool.rest.webservices.restfulwebservices.user;

import com.abcool.rest.webservices.restfulwebservices.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class UserResource {

    @Autowired
    private UserDAO dao;

    @GetMapping(path = "/users")
    public List<User> retrieveAllUsers(){
        return dao.findAll();
    }
    /*@GetMapping(path="/users/{id}")
    public User retrieveUser(@PathVariable int id){
        Optional<User> user = Optional.ofNullable(dao.findOne(id));
        if(user.isEmpty()){
            throw new UserNotFoundException(String.valueOf(id));
        }
            return user.get();
    }*/

    //Hateos Implementation
    @GetMapping(path="/users/{id}")
    public EntityModel<User> retrieveUser(@PathVariable int id){
        Optional<User> user = Optional.ofNullable(dao.findOne(id));
        if(user.isEmpty()){
            throw new UserNotFoundException(String.valueOf(id));
        }
        EntityModel<User> resource = EntityModel.of(user.get());
        WebMvcLinkBuilder link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).retrieveAllUsers());
        resource.add(link.withRel("all-users"));
        return resource;
    }
    @PostMapping(path="/users")
    public ResponseEntity<User> saveUserDetails(@Valid @RequestBody User user){
        Optional<User> savedUser = Optional.ofNullable(dao.save(user));
        if(savedUser.isPresent()){
            URI location =  ServletUriComponentsBuilder
                            .fromCurrentRequest().path("/{id}")
                            .buildAndExpand(savedUser.get().getId())
                            .toUri();

            return ResponseEntity.created(location).body(savedUser.get());
        }else{
            return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping(path="/users/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable int id){
        Optional<User> user = Optional.ofNullable(dao.deleteById(id));
        if(user.isEmpty()){
            throw new UserNotFoundException(String.valueOf(id));
        }
        return new ResponseEntity<User>(user.get(),HttpStatus.OK);
    }
}
