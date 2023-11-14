package com.example.ReigsterLogin.Service;

import Response.LoginResponse;
import com.example.ReigsterLogin.Dto.LoginDTO;
import com.example.ReigsterLogin.Dto.UserDTO;

public interface UserService {
    String addUser(UserDTO userDTO);

    LoginResponse loginUser(LoginDTO loginDTO);

}
