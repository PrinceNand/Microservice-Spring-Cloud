package com.project.config_server_cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigServerCloudApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigServerCloudApplication.class, args);
	}

}
