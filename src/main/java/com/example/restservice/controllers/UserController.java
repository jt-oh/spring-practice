package com.example.restservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.restservice.domains.User.User;
import com.example.restservice.repositories.UserRepository.UserRepository;

@Controller
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
  @ResponseBody
  public Iterable<User> getAllUsers() {
    return userRepository.findAll();
  }
}