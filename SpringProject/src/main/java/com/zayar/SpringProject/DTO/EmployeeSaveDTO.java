package com.zayar.SpringProject.DTO;

public class EmployeeSaveDTO {

    private String employeeName;
    private String employeeAddress;
    private String mobile;

    public EmployeeSaveDTO(String employeeName, String employeeAddress, String mobile) {
        this.employeeName = employeeName;
        this.employeeAddress = employeeAddress;
        this.mobile = mobile;
    }

    public EmployeeSaveDTO() {
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Override
    public String toString() {
        return "EmployeeSaveDTO{" +
                "employeeName='" + employeeName + '\'' +
                ", employeeAddress='" + employeeAddress + '\'' +
                ", mobile=" + mobile +
                '}';
    }
}
