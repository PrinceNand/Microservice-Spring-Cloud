package com.project.department_microservice_spring.mapper;

import com.project.department_microservice_spring.dto.DepartmentDTO;
import com.project.department_microservice_spring.entity.Department;

public class DepartmentMapper {

    public static DepartmentDTO mapToDepartmentDto(Department department){
        return new DepartmentDTO(
                department.getId(),
                department.getDepartmentName(),
                department.getDepartmentDescription(),
                department.getDepartmentCode()
        );
    }

    public static Department mapToDepartment(DepartmentDTO departmentDto){
        return new Department(
                departmentDto.getId(),
                departmentDto.getDepartmentName(),
                departmentDto.getDepartmentDescription(),
                departmentDto.getDepartmentCode()
        );
    }

}
