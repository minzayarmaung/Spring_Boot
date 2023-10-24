package com.example.RegisterLogin.DTO;

public class RegisterDTO {


    private int registerId;
    private String registerName;
    private String registerEmail;
    private String password;

    public RegisterDTO(int registerId, String registerName, String registerEmail, String password) {
        this.registerId = registerId;
        this.registerName = registerName;
        this.registerEmail = registerEmail;
        this.password = password;
    }

    public RegisterDTO() {
    }

    public int getRegisterId() {
        return registerId;
    }

    public void setRegisterId(int registerId) {
        this.registerId = registerId;
    }

    public String getRegisterName() {
        return registerName;
    }

    public void setRegisterName(String registerName) {
        this.registerName = registerName;
    }

    public String getRegisterEmail() {
        return registerEmail;
    }

    public void setRegisterEmail(String registerEmail) {
        this.registerEmail = registerEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String   toString() {
        return "RegisterDTO{" +
                "registerId=" + registerId +
                ", registerName='" + registerName + '\'' +
                ", registerEmail='" + registerEmail + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
