package com.userAuthentication.controller;

import com.userAuthentication.dao.entity.User;
import com.userAuthentication.dto.UserDto;
import com.userAuthentication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "/bookexchangeplatform")
public class LoginAndRegisterController {

    @Autowired
    UserService userService;

    @PostMapping(value = "/login")
    public List<UserDto> loginUser(@RequestBody User user) {
        return userService.getLoggedInUser(user);
    }

    @PostMapping(value = "/register")
    public User registerUser(@RequestBody UserDto user) {
        return userService.save(user);
    }
}
