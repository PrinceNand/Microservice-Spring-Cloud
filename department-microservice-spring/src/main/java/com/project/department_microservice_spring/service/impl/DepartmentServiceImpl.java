package com.project.department_microservice_spring.service.impl;

import com.project.department_microservice_spring.dto.DepartmentDTO;
import com.project.department_microservice_spring.entity.Department;
import com.project.department_microservice_spring.exception.DepartmentCodeAlreadyExits;
import com.project.department_microservice_spring.exception.ResourceNotFoundException;
import com.project.department_microservice_spring.mapper.DepartmentMapper;
import com.project.department_microservice_spring.repository.DepartmentRepository;
import com.project.department_microservice_spring.service.DepartmentService;
import io.micrometer.observation.Observation;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;


    @Override
    public DepartmentDTO saveDepartment(DepartmentDTO departmentDTO) {

        Department codeExists = departmentRepository.findByDepartmentCode(departmentDTO.getDepartmentCode());

        if (codeExists!=null) {
            throw new IllegalArgumentException("Department with code '" + departmentDTO.getDepartmentCode() + "' already exists.");
        }

        // convert department dto to department jpa entity
        Department department = DepartmentMapper.mapToDepartment(departmentDTO);

        Department savedDepartment = departmentRepository.save(department);

        // convert department jpa entity to department dto
        return DepartmentMapper.mapToDepartmentDto(savedDepartment);
    }

    @Override
    public DepartmentDTO getDepartmentByCode(String code) {
        Department department = departmentRepository.findByDepartmentCode(code);

        if (department == null) {
            throw new ResourceNotFoundException("Department does not exists");
        }
        // convert department jpa entity to department dto
        return DepartmentMapper.mapToDepartmentDto(department);
    }
}
