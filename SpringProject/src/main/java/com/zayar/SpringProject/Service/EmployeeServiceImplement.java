package com.zayar.SpringProject.Service;

import com.zayar.SpringProject.DTO.EmployeeDTO;
import com.zayar.SpringProject.DTO.EmployeeSaveDTO;
import com.zayar.SpringProject.DTO.EmployeeUpdateDTO;
import com.zayar.SpringProject.Entity.Employee;
import com.zayar.SpringProject.Repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImplement implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepoitory;

    @Override
    public String addEmployee(EmployeeSaveDTO employeeSaveDTO) {

        Employee employee = new Employee(
                employeeSaveDTO.getEmployeeName(),
                employeeSaveDTO.getEmployeeAddress(),
                employeeSaveDTO.getMobile()
        );
        employeeRepoitory.save(employee);
        return employee.getEmployeeName();
    }

    @Override
    public List<EmployeeDTO> getAllEmployee() {

        List<Employee> getEmployees = employeeRepoitory.findAll();
        List<EmployeeDTO> employeeDTOList = new ArrayList<>();

        for (Employee e : getEmployees) {
            EmployeeDTO employeeDTO = new EmployeeDTO(
                    e.getEmployeeId(),
                    e.getEmployeeName(),
                    e.getEmployeeAddress(),
                    e.getMobile()
            );
            employeeDTOList.add(employeeDTO);
        }
        return employeeDTOList;
    }

    @Override
    public String updateEmployee(EmployeeUpdateDTO employeeUpdateDTO) {

        if(employeeRepoitory.existsById(employeeUpdateDTO.getEmployeeId())){

            Employee employee = employeeRepoitory.getById(employeeUpdateDTO.getEmployeeId());

            employee.setEmployeeName(employeeUpdateDTO.getEmployeeName());
            employee.setEmployeeAddress(employeeUpdateDTO.getEmployeeAddress());
            employee.setMobile(employeeUpdateDTO.getMobile());

            employeeRepoitory.save(employee);

        }
        else {
            System.out.println("Employee ID Not Found or Exist");
        }

        return null;
    }

    @Override
    public boolean deleteEmployee(int id) {

        if(employeeRepoitory.existsById(id)){
            employeeRepoitory.deleteById(id);
        }
        else {
            System.out.println("Employee ID Not Found or Exist");
        }

        return false;
    }
}
