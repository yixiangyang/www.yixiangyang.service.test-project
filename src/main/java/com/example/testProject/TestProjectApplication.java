package com.example.testProject;
import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

import jxl.JXLException;

@SpringBootApplication
@ComponentScans({@ComponentScan("com.*.service"), @ComponentScan("com.*.controller")})
public class TestProjectApplication {

	public static void main(String[] args) throws IOException, JXLException {
		SpringApplication.run(TestProjectApplication.class, args);
		
		
		
	}
}
