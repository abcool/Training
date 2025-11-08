package com.abcool.rest.webservices.restfulwebservices.user;

import javax.persistence.*;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.abcool.rest.webservices.restfulwebservices.post.Post;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.GeneratorType;

import java.time.LocalDateTime;
import java.util.List;

@ApiModel(description="Details about user")
@Entity
public class User {
    @Id
    @GeneratedValue
    private Integer id;
    
    @Size(min=2,message = "Name should be at least of length 2")
    @ApiModelProperty(notes = "Name should be at least of length 2")
    private String name;
    
    @ApiModelProperty(notes="Date of birth should be older than current date")
    @Past(message = "Date of birth should be older than current date")
    private LocalDateTime birthDate;

    @OneToMany(mappedBy = "user")
    private List<Post> posts;

    public User() {
    }

    public User(Integer id, String name, LocalDateTime birthDate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getBirthDate() {
        return birthDate;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthDate(LocalDateTime birthDate) {
        this.birthDate = birthDate;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}
