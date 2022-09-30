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
  @ResponseBody
  public String addNewUser (@RequestParam String name, @RequestParam String email) {

    User n = new User();
    n.setName(name);
    n.setEmail(email);
    userRepository.save(n);
    
    return "Saved";
  }

  @GetMapping(path="")
  public Iterable<User> getAllUsers() {
    return userRepository.findAll();
  }
}