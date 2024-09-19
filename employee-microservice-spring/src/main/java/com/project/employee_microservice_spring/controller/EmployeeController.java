package com.project.employee_microservice_spring.controller;

import com.project.employee_microservice_spring.dto.ApiResponseDto;
import com.project.employee_microservice_spring.dto.DepartmentDto;
import com.project.employee_microservice_spring.dto.EmployeeDto;
import com.project.employee_microservice_spring.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@AllArgsConstructor
@RequestMapping("api/employees")
public class EmployeeController {

    EmployeeService employeeService;

    @PostMapping("create")
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto savedEmployee = employeeService.saveEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @GetMapping("getEmployeeById/{id}")
    public ResponseEntity<ApiResponseDto> getEmployeeById(@PathVariable Long id){
        ApiResponseDto apiResponseDto = employeeService.getEmployeeById(id);
        return ResponseEntity.ok(apiResponseDto);
    }
}
