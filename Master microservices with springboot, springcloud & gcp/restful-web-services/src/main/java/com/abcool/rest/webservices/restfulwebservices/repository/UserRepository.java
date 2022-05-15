package com.abcool.rest.webservices.restfulwebservices.repository;

import com.abcool.rest.webservices.restfulwebservices.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
}
