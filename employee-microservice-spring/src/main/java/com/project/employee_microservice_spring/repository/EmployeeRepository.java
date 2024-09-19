package com.project.employee_microservice_spring.repository;

import com.project.employee_microservice_spring.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository  extends JpaRepository<Employee, Long> {

    Optional<Employee> findByEmail(String email);

}
