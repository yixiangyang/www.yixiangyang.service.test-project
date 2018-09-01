package com.xiangyang.service;

import com.xiangyang.model.TestUser;

public interface UserService {
	public TestUser getUser(String id);
	
	public TestUser createUser(String name,String age,String email,String phone);
}
