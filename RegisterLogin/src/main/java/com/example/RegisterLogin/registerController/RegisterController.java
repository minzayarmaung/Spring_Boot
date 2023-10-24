package com.example.RegisterLogin.registerController;

import com.example.RegisterLogin.DTO.LoginDTO;
import com.example.RegisterLogin.DTO.RegisterDTO;
import com.example.RegisterLogin.Response.LoginResponse;
import com.example.RegisterLogin.Service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/v1/register")

public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @PostMapping(path = "/save")
    public String saveRegister(@RequestBody RegisterDTO registerDTO) {

    String id = registerService.addRegister(registerDTO);
    return id;

    }

    @PostMapping(path = "/login")
    public ResponseEntity<?> loginUser (@RequestBody LoginDTO loginDTO){
        LoginResponse loginResponse = registerService.loginResponse(loginDTO);
        return ResponseEntity.ok(loginResponse);
    }


}
