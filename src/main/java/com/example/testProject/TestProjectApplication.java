package com.example.testProject;
//import java.io.IOException;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

//import jxl.JXLException;
//

@EnableAutoConfiguration
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class,MybatisAutoConfiguration.class})
//@EnableEurekaClient
//@EnableDiscoveryClient
@MapperScan("com.*.mapper")
@ComponentScan(basePackages={"com.xiangyang.controller", "com.xiangyang.service"})
public class TestProjectApplication {
	/*@Bean
	public CommandLineRunner commandLineRunner() {
		return new HelloWorldCommandLineRunner();
	}*/

	public static void main(String[] args){
		SpringApplication.run(TestProjectApplication.class, args);
		
	}
	/*public static class HelloWorldCommandLineRunner implements CommandLineRunner {

		@Override
		public void run(String... strings) throws Exception {
			System.out.println("Hello World!");
		}
	}*/
}
