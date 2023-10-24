package com.example.RegisterLogin.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "register")
public class Register {
    @Id
    @Column(name = "register_id", length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int registerId;

    @Column(name = "register_name" , length = 255)
    private String registerName;

    @Column(name = "register_email" , length = 255)
    private String registerEmail;

    @Column(name = "register_password" , length = 255)
    private String password;

    public Register(int registerId, String registerName, String registerEmail, String password) {
        this.registerId = registerId;
        this.registerName = registerName;
        this.registerEmail = registerEmail;
        this.password = password;
    }

    public Register() {
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
    public String toString() {
        return "Register{" +
                "registerId=" + registerId +
                ", registerName='" + registerName + '\'' +
                ", registerEmail='" + registerEmail + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
