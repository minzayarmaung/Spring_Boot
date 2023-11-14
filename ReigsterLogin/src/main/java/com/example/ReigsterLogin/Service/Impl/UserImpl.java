package com.example.ReigsterLogin.Service.Impl;

import Response.LoginResponse;
import com.example.ReigsterLogin.Dto.LoginDTO;
import com.example.ReigsterLogin.Dto.UserDTO;
import com.example.ReigsterLogin.Entity.User;
import com.example.ReigsterLogin.Repo.UserRepo;
import com.example.ReigsterLogin.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public String addUser(UserDTO userDTO) {
        User user = new User(
                userDTO.getUserId(),
                userDTO.getUserName(),
                userDTO.getEmail(),
                this.passwordEncoder.encode(userDTO.getPassword())
        );

        userRepo.save(user);

        return "User "+ user.getUserName() + " is Registered Successfully";
    }

    UserDTO userDTO;

    @Override
    public LoginResponse loginUser(LoginDTO loginDTO) {
        String msg = "";
        User user = userRepo.findByEmail(loginDTO.getEmail());
        if(user!=null){
            String password = loginDTO.getPassword();
            String encodedPassword = user.getPassword();
            Boolean isPwRight =
                    passwordEncoder.matches(password , encodedPassword);

            if(isPwRight) {
                Optional<User> user1 = userRepo.
                        findOneByEmailAndPassword(loginDTO.getEmail(), encodedPassword);

                if (user1.isPresent()) {
                    return new LoginResponse( "Login Success", true);
                } else {
                    return new LoginResponse("Login Failed", false);
                }
            } else {
                return new LoginResponse("Password not Match ", false);
            }
        }else {
            return new LoginResponse("Email not Exist", false);
        }
    }
}
