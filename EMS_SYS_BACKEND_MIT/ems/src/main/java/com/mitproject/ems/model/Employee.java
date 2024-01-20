package com.mitproject.ems.model;

import jakarta.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "employee_name")
    private String name;
    @Column(name = "employee_email")
    private String email;
    @Column(name = "employee_nrc")
    private String nrc;
    @Column(name = "employee_interest")
    private String interest;

    public Employee() {
    }

    public Employee(String name, String email, String nrc, String interest) {
        this.name = name;
        this.email = email;
        this.nrc = nrc;
        this.interest = interest;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNrc() {
        return nrc;
    }

    public void setNrc(String nrc) {
        this.nrc = nrc;
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }
}
