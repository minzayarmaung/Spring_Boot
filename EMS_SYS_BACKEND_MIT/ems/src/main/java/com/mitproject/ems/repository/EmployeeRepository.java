package com.mitproject.ems.repository;

import com.mitproject.ems.model.Employee;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>  {
// < Primary Key , Type of Primary Key>

}
