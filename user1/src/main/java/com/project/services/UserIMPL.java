package com.project.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.DTO.LoginDTO;
import com.project.DTO.UserDTO;
import com.project.config.LoginResponse;
import com.project.entity.User;
import com.project.repository.UserRepo;

@Service
public class UserIMPL implements UserService{

	@Autowired
    private UserRepo userRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public String addUser(UserDTO userDTO) {
       User user = new User(
    		   userDTO.getId(),
    		   userDTO.getName(),
    		   userDTO.getEmail(),
    		  
               this.passwordEncoder.encode(userDTO.getPassword()),
               userDTO.getRole()
        );
        userRepo.save(user);
        return user.getName();
    }
    UserDTO userDTO;
    @Override
    public LoginResponse  loginUser(LoginDTO loginDTO) {
        String msg = "";
       User user1 = userRepo.findByEmail(loginDTO.getEmail());
        if (user1 != null) {
            String password = loginDTO.getPassword();
            String encodedPassword = user1.getPassword();
            Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
            if (isPwdRight) {
                Optional<User> employee = userRepo.findOneByEmailAndPassword(loginDTO.getEmail(), encodedPassword);
                if (employee.isPresent()) {
                    return new LoginResponse("Login Success", true);
                } else {
                    return new LoginResponse("Login Failed", false);
                }
            } else {
                return new LoginResponse("password Not Match", false);
            }
        }else {
            return new LoginResponse("Email not exits", false);
        }
    }
}
