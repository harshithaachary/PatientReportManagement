package com.project.services;

import com.project.DTO.LoginDTO;
import com.project.DTO.UserDTO;
import com.project.config.LoginResponse;

public interface UserService {
	String addUser(UserDTO userDTO);
    LoginResponse loginUser(LoginDTO loginDTO);
}
