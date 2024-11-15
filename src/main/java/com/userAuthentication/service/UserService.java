package com.userAuthentication.service;

import com.userAuthentication.dao.entity.User;
import com.userAuthentication.dto.UserDto;

import java.util.List;

public interface UserService {

    User save(UserDto user);
    public List<UserDto> getLoggedInUser(User user);
}
