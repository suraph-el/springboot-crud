package com.cogni.springaws.controller;

import com.cogni.springaws.domain.User;
import com.cogni.springaws.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    //get all users
    @GetMapping
    public List<User> getAllUsers(){
        return this.userRepository.findAll();
    }
    //get user by id
    @GetMapping("/{id}")
    public User getUserById(@PathVariable (value = "id") long userId){
        return this.userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFound("user not found with id : " + userId));
    }

    // create user
    @PostMapping
    public User createUser(@RequestBody User user){
        return userRepository.save(user);
    }

    //update user
    @PutMapping("/{id}")
    public User updateUser(@RequestBody User user,@PathVariable("id") long userID){
        User existing = this.userRepository.findById(userID)
                .orElseThrow(() ->new ResourceNotFound("user not found" + userID));
        existing.setFirstName(user.getFirstName());
        existing.setLastName(user.getLastName());
        existing.setEmail(user.getEmail());
        return this.userRepository.save(existing);
    }
    //delete user
    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable ("id") long userId){
        User existingUser = this.userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFound("user not found with id :" + userId));
        this.userRepository.delete(existingUser);
        return ResponseEntity.ok().build();
    }

}
