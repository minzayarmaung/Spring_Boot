package com.example.RegisterLogin.DTO;

public class LoginDTO {
    private String registerEmail;
    private String password;

    public LoginDTO(String registerEmail, String password) {
        this.registerEmail = registerEmail;
        this.password = password;
    }

    public LoginDTO() {
    }

    public String getRegisterEmail() {
        return registerEmail;
    }

    public void setEmail(String registerEmail) {
        this.registerEmail = registerEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "loginDTO{" +
                "email='" + registerEmail + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
