package com.example.ReigsterLogin.Controller;

import Response.LoginResponse;
import com.example.ReigsterLogin.Dto.LoginDTO;
import com.example.ReigsterLogin.Dto.UserDTO;
import com.example.ReigsterLogin.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;



    @PostMapping(path = "/save")
    public String saveEmployee(@RequestBody UserDTO userDTO){
        String id = userService.addUser(userDTO);
        return id;
    }

    @PostMapping(path = "/login")
    public ResponseEntity<?> loginEmployee(@RequestBody LoginDTO loginDTO){
        LoginResponse loginResponse = userService.loginUser(loginDTO);
        return ResponseEntity.ok(loginResponse);
    }

}
