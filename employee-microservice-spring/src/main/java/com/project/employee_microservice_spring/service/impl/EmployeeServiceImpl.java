package com.project.employee_microservice_spring.service.impl;

import com.project.employee_microservice_spring.dto.ApiResponseDto;
import com.project.employee_microservice_spring.dto.DepartmentDto;
import com.project.employee_microservice_spring.dto.EmployeeDto;
import com.project.employee_microservice_spring.entity.Employee;
import com.project.employee_microservice_spring.exception.EmailAlreadyExistsExceptions;
import com.project.employee_microservice_spring.exception.ResourceNotFoundException;
import com.project.employee_microservice_spring.mapper.EmployeeMapper;
import com.project.employee_microservice_spring.repository.EmployeeRepository;
import com.project.employee_microservice_spring.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    public EmployeeRepository employeeRepository;
    private RestTemplate restTemplate;

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
    public ApiResponseDto getEmployeeById(Long employeeId) {


        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResourceNotFoundException("Employee does not exists")
        );

        ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity("http://localhost:8080/api/departments/getDepartmentByCode/" + employee.getDepartmentCode(), DepartmentDto.class);
        DepartmentDto departmentDto = responseEntity.getBody();

        EmployeeDto employeeDto = EmployeeMapper.mapToEmployeeDto(employee);

        ApiResponseDto apiResponseDto = new ApiResponseDto();
        apiResponseDto.setEmployeeDto(employeeDto);
        apiResponseDto.setDepartmentDto(departmentDto);

        return apiResponseDto;

    }
}
