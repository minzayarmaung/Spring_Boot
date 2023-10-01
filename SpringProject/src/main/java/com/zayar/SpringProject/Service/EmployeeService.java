package com.zayar.SpringProject.Service;

import com.zayar.SpringProject.DTO.EmployeeDTO;
import com.zayar.SpringProject.DTO.EmployeeSaveDTO;
import com.zayar.SpringProject.DTO.EmployeeUpdateDTO;

import java.util.List;

public interface EmployeeService {
    String addEmployee(EmployeeSaveDTO employeeSaveDTO);

    List<EmployeeDTO> getAllEmployee();

    String updateEmployee(EmployeeUpdateDTO employeeUpdateDTO);

    boolean deleteEmployee(int id);
}
