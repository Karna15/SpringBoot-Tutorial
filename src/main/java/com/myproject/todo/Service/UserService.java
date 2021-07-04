package com.myproject.todo.Service;

import java.util.List;

import com.myproject.todo.Entity.User;
import com.myproject.todo.Exception.NoUserFound;
import com.myproject.todo.Repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userrepository;

    public List<User> getAllUser() {
        return userrepository.findAll();
    }

    public User addUser(User user) {
        return userrepository.save(user);
    }

    public String deleteUser(long user_id) {
        userrepository.deleteById(user_id);
        return "Deleted User id :" + user_id ;
    }

    public User updateUser(User user) {
        if (userrepository.findById(user.getUser_id()).isPresent()) {
            User user1 = userrepository.findById(user.getUser_id()).orElse(null);
            user1.setFirst_name(user.getFirst_name());
            user1.setLast_name(user.getLast_name());
            return userrepository.save(user1);
        } else {
            throw new NoUserFound("No User for ID: " + user.getUser_id());
        }
    }

}
