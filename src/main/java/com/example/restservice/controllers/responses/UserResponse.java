package com.example.restservice.controllers.responses;

import com.example.restservice.domains.User.User;
import lombok.Getter;

@Getter
public class UserResponse {
    private Integer id;
    private String name;
    private String email;

    public UserResponse(User userEntity) {
        this.id = userEntity.getId();
        this.name = userEntity.getName();
        this.email = userEntity.getEmail();
    }
}
