package com.project.employee_microservice_spring.controller;

import com.project.employee_microservice_spring.dto.EmployeeDto;
import com.project.employee_microservice_spring.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<EmployeeDto> getAccountById(@PathVariable Long id){
        EmployeeDto accountDto = employeeService.getEmployeeById(id);
        return ResponseEntity.ok(accountDto);
    }
}
