package com.xiangyang.testJuit;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.testProject.TestProjectApplication;
import com.xiangyang.service.UserService;


@RunWith(SpringRunner.class)
@SpringBootTest(classes={TestProjectApplication.class})
public class test {
	@Resource
	private UserService userService;
	
	//@Test
	public void getUser(){
		userService.getUser("1");
	}
	
	@Test
	public void createUser(){
		userService.createUser("向阳", "18", "2282", "151387");
	}
}
