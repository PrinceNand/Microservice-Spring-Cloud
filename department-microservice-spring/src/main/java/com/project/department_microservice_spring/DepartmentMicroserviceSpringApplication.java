package com.project.department_microservice_spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DepartmentMicroserviceSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(DepartmentMicroserviceSpringApplication.class, args);
	}

	// for multiple instance using jar maven>lifecycle>package and type command in terminal
	// cd department-microservice-spring
	//java -jar -Dserver.port={enterNewPortNumber} target/-jarName-
	//java -jar -Dserver.port=8085 target/department-microservice-spring-0.0.1-SNAPSHOT.jar
}
