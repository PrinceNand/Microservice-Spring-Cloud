package com.project.employee_microservice_spring.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponseDto {

    private DepartmentDto departmentDto;
    private EmployeeDto employeeDto;
}
