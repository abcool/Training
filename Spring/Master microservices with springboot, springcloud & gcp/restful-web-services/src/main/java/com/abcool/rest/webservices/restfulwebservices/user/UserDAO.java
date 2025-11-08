package com.abcool.rest.webservices.restfulwebservices.user;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class UserDAO {

    private static List<User> users = new ArrayList<>();

    static{
        users.add(new User(1,"Rahul", LocalDateTime.now()));
        users.add(new User(2,"Priya", LocalDateTime.now()));
        users.add(new User(3,"Mohan", LocalDateTime.now()));
    }
    private static int usersCount = 3;
    public List<User> findAll(){
        return users;
    }
    public User save(User user){
        if(user.getId()==null)
            user.setId(++usersCount);
        users.add(user);
        return user;
    }
    public User findOne(int id){
      try {
            User user = users
                    .parallelStream()
                    .filter(x -> x.getId() == id)
                    .collect(Collectors.toList())
                    .get(0);
            return user;
        }catch(IndexOutOfBoundsException e){
          return null;
        }
    }
    public User deleteById(int id){
        Optional<User> user = Optional.ofNullable(findOne(id));
        if(user.isPresent()) {
            users.remove(user.get());
            return user.get();
        }else{
            return null;
        }
    }
}
