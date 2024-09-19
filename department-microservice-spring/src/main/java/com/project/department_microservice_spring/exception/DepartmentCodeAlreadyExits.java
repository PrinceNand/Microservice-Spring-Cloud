package com.project.department_microservice_spring.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class DepartmentCodeAlreadyExits extends RuntimeException{

    private String message;

    public DepartmentCodeAlreadyExits(String message) {
        super(message);
        this.message = message;
    }
}
