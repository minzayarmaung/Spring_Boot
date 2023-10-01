package com.zayar.SpringProject.EmployeeController;

import com.zayar.SpringProject.DTO.EmployeeDTO;
import com.zayar.SpringProject.DTO.EmployeeSaveDTO;
import com.zayar.SpringProject.DTO.EmployeeUpdateDTO;
import com.zayar.SpringProject.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/save")
    public String saveEmoloyee(@RequestBody EmployeeSaveDTO employeeSaveDTO){
        String id = employeeService.addEmployee(employeeSaveDTO);
        return id;
    }
    @GetMapping("/allEmployees")
    public List<EmployeeDTO> getAllEmployee(){
        List<EmployeeDTO>allEmployees = employeeService.getAllEmployee();
        return allEmployees;
    }
    @PutMapping("/update")
    public String updateEmployee(@RequestBody EmployeeUpdateDTO employeeUpdateDTO){

        String id = employeeService.updateEmployee(employeeUpdateDTO);
        return id;
    }
    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable(value = "id") int id){
        boolean deleteEmployee = employeeService.deleteEmployee(id);
        return "deleted";
    }
}
