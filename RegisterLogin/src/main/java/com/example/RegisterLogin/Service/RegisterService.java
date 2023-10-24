package com.example.RegisterLogin.Service;

import com.example.RegisterLogin.DTO.LoginDTO;
import com.example.RegisterLogin.DTO.RegisterDTO;
import com.example.RegisterLogin.Response.LoginResponse;

public interface RegisterService {
	
    String addRegister(RegisterDTO registerDTO);

	LoginResponse loginResponse(LoginDTO loginDTO);
}
