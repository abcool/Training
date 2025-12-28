package com.abcool.rest.webservices.restfulwebservices.repository;

import com.abcool.rest.webservices.restfulwebservices.post.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Integer> {
}
