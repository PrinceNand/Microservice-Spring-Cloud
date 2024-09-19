package com.project.employee_microservice_spring.service.impl;

import com.project.employee_microservice_spring.dto.EmployeeDto;
import com.project.employee_microservice_spring.entity.Employee;
import com.project.employee_microservice_spring.exception.EmailAlreadyExistsExceptions;
import com.project.employee_microservice_spring.exception.ResourceNotFoundException;
import com.project.employee_microservice_spring.mapper.EmployeeMapper;
import com.project.employee_microservice_spring.repository.EmployeeRepository;
import com.project.employee_microservice_spring.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    public EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {

        Optional<Employee> optionalUser = employeeRepository.findByEmail(employeeDto.getEmail());
        if (optionalUser.isPresent()){
            throw new EmailAlreadyExistsExceptions("Email Already Exists for User");
        }

        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);

        Employee saveDEmployee = employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(saveDEmployee);
    }


    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {

        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResourceNotFoundException("Employee does not exists")
        );

        return EmployeeMapper.mapToEmployeeDto(employee);

    }
}
