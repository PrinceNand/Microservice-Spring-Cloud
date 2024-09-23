package com.project.department_microservice_spring.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class MessageController {

    // add "spring.boot.message= Hello department Service!" in git cloud repo - department
    @Value("${spring.boot.message}")
    private String message;

    @GetMapping("message")
    public String message() {
        return message;

    }

}
