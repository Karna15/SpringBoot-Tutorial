package com.myproject.todo.Controller;

import java.util.List;

import com.myproject.todo.Entity.User;
import com.myproject.todo.Service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    UserService service;

    @GetMapping("/index")
    public String index(){
        return "Hello world";
    }

    @GetMapping("/view")
    public List<User> getAllUser() {
        return service.getAllUser();
    }

    @PostMapping("/add")
    public User createUser(@RequestBody User user){
         ((UserService) service).addUser(user);
         return user;
    }

    @DeleteMapping("/delete/{user_id}")
    public String deleteUser(@PathVariable(value = "user_id") long user_id){
        return service.deleteUser(user_id);
    }

    @PutMapping("/update")
    public User updateUser(@RequestBody User user){
        return service.updateUser(user);
    }
    
}
