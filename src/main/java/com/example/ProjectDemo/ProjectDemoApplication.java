package com.example.ProjectDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.example.ProjectDemo.Config.SecurityConfig;

@SpringBootApplication
@Import({SecurityConfig.class})
public class ProjectDemoApplication {

	public static void main(String[] args) { 
		SpringApplication.run(ProjectDemoApplication.class, args);
	}

}
