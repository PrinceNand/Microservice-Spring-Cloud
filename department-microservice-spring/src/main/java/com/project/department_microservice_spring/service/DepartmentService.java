package com.project.department_microservice_spring.service;

import com.project.department_microservice_spring.dto.DepartmentDTO;

public interface DepartmentService {

    DepartmentDTO saveDepartment(DepartmentDTO departmentDTO);

    DepartmentDTO getDepartmentByCode(String code);
}
