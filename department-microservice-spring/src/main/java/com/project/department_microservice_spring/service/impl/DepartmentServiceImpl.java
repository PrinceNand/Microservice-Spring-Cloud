package com.project.department_microservice_spring.service.impl;

import com.project.department_microservice_spring.dto.DepartmentDTO;
import com.project.department_microservice_spring.entity.Department;
import com.project.department_microservice_spring.mapper.DepartmentMapper;
import com.project.department_microservice_spring.repository.DepartmentRepository;
import com.project.department_microservice_spring.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;


    @Override
    public DepartmentDTO saveDepartment(DepartmentDTO departmentDTO) {

        // convert department dto to department jpa entity
        Department department = DepartmentMapper.mapToDepartment(departmentDTO);

        Department savedDepartment = departmentRepository.save(department);

        // convert department jpa entity to department dto
        return DepartmentMapper.mapToDepartmentDto(savedDepartment);
    }

    @Override
    public DepartmentDTO getDepartmentByCode(String code) {
        Department department = departmentRepository.findByDepartmentCode(code);

        // convert department jpa entity to department dto
        return DepartmentMapper.mapToDepartmentDto(department);
    }
}
