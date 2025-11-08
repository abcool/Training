package com.abcool.rest.webservices.restfulwebservices.user;

import com.abcool.rest.webservices.restfulwebservices.exception.PostNotFoundException;
import com.abcool.rest.webservices.restfulwebservices.exception.UserNotFoundException;
import com.abcool.rest.webservices.restfulwebservices.post.Post;
import com.abcool.rest.webservices.restfulwebservices.repository.PostRepository;
import com.abcool.rest.webservices.restfulwebservices.repository.UserRepository;
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
public class UserJPAResource {

    @Autowired
    private UserRepository repository;

    @Autowired
    private PostRepository postRepo;

    @GetMapping(path = "/jpa/users")
    public List<User> retrieveAllUsers(){
        return repository.findAll();
    }

    //Hateos Implementation
    @GetMapping(path="/jpa/users/{id}")
    public EntityModel<User> retrieveUser(@PathVariable int id){
        Optional<User> user = repository.findById(id);
        if(user.isEmpty()){
            throw new UserNotFoundException(String.valueOf(id));
        }
        EntityModel<User> resource = EntityModel.of(user.get());
        WebMvcLinkBuilder link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).retrieveAllUsers());
        resource.add(link.withRel("all-users"));
        return resource;
    }
    @PostMapping(path="/jpa/users")
    public ResponseEntity<User> saveUserDetails(@Valid @RequestBody User user){
        int size = repository.findAll().size();
        user.setId(++size);
        Optional<User> savedUser = Optional.ofNullable(repository.save(user));
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
    @DeleteMapping(path="/jpa/users/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable int id){
        Optional<User> user = repository.findById(id);
        if(user.isEmpty()){
            throw new UserNotFoundException(String.valueOf(id));
        }else{
            repository.deleteById(id);
        }
        return new ResponseEntity<User>(user.get(),HttpStatus.OK);
    }
    @GetMapping(path = "/jpa/users/{userId}/posts")
    public List<Post> retrieveAllPostsForUser(@PathVariable Integer userId){
        Optional<User> user= repository.findById(userId);
        if(user.isEmpty()){
            throw new UserNotFoundException(String.valueOf(userId));
        }
        List<Post> posts = user.get().getPosts();
        if(posts.isEmpty()){
            throw new PostNotFoundException(user.get().getName());
        }
        return posts;
    }

    @PostMapping(path="/jpa/users/{userId}/posts")
    public ResponseEntity<Post> createPost(@Valid @PathVariable Integer userId, @RequestBody Post post){
        Optional<User> user= repository.findById(userId);
        if(user.isEmpty()){
            throw new UserNotFoundException(String.valueOf(userId));
        }
        int size = user.get().getPosts().size();
        post.setPostId(++size);
        post.setUser(user.get());
        Optional<Post> savedPost = Optional.ofNullable(postRepo.save(post));
        if(savedPost.isPresent()){
            URI location =  ServletUriComponentsBuilder
                    .fromCurrentRequest().path("/{id}")
                    .buildAndExpand(savedPost.get().getPostId())
                    .toUri();

            return ResponseEntity.created(location).body(savedPost.get());
        }else{
            return new ResponseEntity<Post>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
