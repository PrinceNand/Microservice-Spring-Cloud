package com.project.employee_microservice_spring.service;

import com.project.employee_microservice_spring.dto.DepartmentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "department-microservice-spring")
public interface ApiClient {

    // Build get department rest api
    @GetMapping("api/departments/getDepartmentByCode/{department-code}")
    DepartmentDto getDepartment(@PathVariable("department-code") String departmentCode);

}
