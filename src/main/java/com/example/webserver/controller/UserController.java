package com.example.webserver.controller;

import com.example.webserver.exception.ResourceNotFoundException;
import com.example.webserver.model.Subject;
import com.example.webserver.model.User;
import com.example.webserver.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/login")
    public String login(@Valid @RequestBody User  user){
        if(userService.login(user.getUserName(),user.getPassword())) return "OK";
        else return "NO";
    }

    @PostMapping("/register")
    public String register(@Valid @RequestBody User  user){
        if(!user.getPassword().equals(user.getMatchingPassword())) return "password doesn't match";
        if(userService.register(user)) return "OK";
       else return "NO";
    }

    @GetMapping("/user")
    public List<User> getAllUser() {
        return userService.findAll();
    }


    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
        return ResponseEntity.ok(userService.findById(id));

    }

    @PostMapping("/user")
    public User createUser(@RequestBody User user){
        return  userService.save(user);
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<Exception> deleteUser(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
        userService.delete(id);
        return ResponseEntity.ok(new Exception("User with id:"+id+" deleted"));
    }

    @PatchMapping(value = "/user/{id}")
    public ResponseEntity<User> patchUser(@PathVariable Long id, @RequestBody User req) throws ResourceNotFoundException {
        return ResponseEntity.ok(userService.updateUser(req,id));
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<User> putUser(@PathVariable Long id,@RequestBody User req) throws ResourceNotFoundException {
        return ResponseEntity.ok(userService.putMet(id,req));
    }
}















