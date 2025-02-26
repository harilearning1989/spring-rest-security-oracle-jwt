package com.web.demo.services;

import com.web.demo.dtos.UserRequestDto;
import com.web.demo.models.Users;

import java.util.List;

public interface UserService {
    List<Users> getAllUsers();
    String registerUser(UserRequestDto employeeRequestDto);
}
