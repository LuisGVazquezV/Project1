package com.revature.controllers;

import com.revature.models.User;
import com.revature.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService us;

    @Autowired
    public UserController(UserService us) {
        this.us = us;
    }

    @PostMapping
    public ResponseEntity<User> registerUser(@RequestBody User newUser){
        User u = us.registerUser(newUser);
        return ResponseEntity.status(201).body(u);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = us.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable String username){
        return ResponseEntity.ok(us.getUserByUsername(username));
    }

    @PatchMapping("/{userId}")
    public ResponseEntity<Object> updateUsername(@RequestBody String username, @PathVariable int userId){
        User updatedUser = us.updateUser(username, userId);

        if(updatedUser == null){
            return ResponseEntity.status(400).body("User not found with ID: " + userId);
        }else{
            return ResponseEntity.ok(updatedUser);
        }
    }

}
