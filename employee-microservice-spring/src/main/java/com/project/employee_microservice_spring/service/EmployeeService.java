package com.project.employee_microservice_spring.service;

import com.project.employee_microservice_spring.dto.EmployeeDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

public interface EmployeeService {

    EmployeeDto saveEmployee(EmployeeDto employeeDto);

}
