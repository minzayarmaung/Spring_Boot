package com.example.RegisterLogin.Service.impl;

import com.example.RegisterLogin.DTO.LoginDTO;
import com.example.RegisterLogin.DTO.RegisterDTO;
import com.example.RegisterLogin.Entity.Register;
import com.example.RegisterLogin.Repo.RegisterRepo;
import com.example.RegisterLogin.Response.LoginResponse;
import com.example.RegisterLogin.Service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RegisterImpl implements RegisterService {

    @Autowired
    private RegisterRepo registerRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public String addRegister(RegisterDTO registerDTO) {
        Register register = new Register(
                registerDTO.getRegisterId(),
                registerDTO.getRegisterName(),
                registerDTO.getRegisterEmail(),
                this.passwordEncoder.encode(registerDTO.getPassword())
        );
        registerRepo.save(register);

        return "Registered Successfully";
    }

    @Override
    public LoginResponse loginResponse (LoginDTO loginDTO) {
        String msg = "";
        Register employee1 = registerRepo.findByRegisterEmail(loginDTO.getRegisterEmail());
        if (employee1 != null) {
            String password = loginDTO.getPassword();
            String encodedPassword = employee1.getPassword();
            Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
            if (isPwdRight) {
                Optional<Register> employee = registerRepo.findByRegisterEmailAndPassword(loginDTO.getRegisterEmail(), encodedPassword);
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
