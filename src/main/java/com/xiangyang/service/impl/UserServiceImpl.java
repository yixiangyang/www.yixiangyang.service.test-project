package com.xiangyang.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xiangyang.mapper.UserMapper;
import com.xiangyang.model.TestUser;
import com.xiangyang.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Resource
	private UserMapper userMapper;
	
	@Override
	public TestUser getUser(String id) {
		TestUser testUser = userMapper.getUser(id);
		return testUser;
	}
	
	@Override
	public TestUser createUser(String name, String age, String email, String phone) {
		TestUser testUser = new TestUser(name, age, email, phone);
		 userMapper.addUser(testUser);
		return testUser;
	}
	
}
