package com.web.demo.services;

import com.web.demo.dtos.UserRequestDto;

public interface UserService {
    //List<Users> getAllUsers();
    String registerUser(UserRequestDto employeeRequestDto);
}
