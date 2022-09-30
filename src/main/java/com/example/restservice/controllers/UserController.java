package com.example.restservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.restservice.domains.User.User;
import com.example.restservice.repositories.UserRepository.UserRepository;

@RestController
@RequestMapping(path="/api/v1/users")
public class UserController {
  @Autowired
  private UserRepository userRepository;

  @PostMapping(path="")
    public Integer addNewUser (@RequestParam String name, @RequestParam String email) {
        User user = new User(name, email);

        User createdUser = userRepository.save(user);
    
        return createdUser.getId();
  }

  @GetMapping(path="")
  public Iterable<User> getAllUsers() {
    return userRepository.findAll();
  }
}