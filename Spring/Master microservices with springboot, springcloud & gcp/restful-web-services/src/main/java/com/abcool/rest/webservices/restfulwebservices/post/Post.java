package com.abcool.rest.webservices.restfulwebservices.post;

import com.abcool.rest.webservices.restfulwebservices.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Post {
    @Id
    @GeneratedValue
    private Integer postId;
    private String description;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    public Post() {
    }

    public Post(Integer postId, String description) {
        this.postId = postId;
        this.description = description;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Post{" +
                "postId=" + postId +
                ", description='" + description + '\'' +
                '}';
    }
}
