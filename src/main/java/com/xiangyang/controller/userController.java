package com.xiangyang.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xiangyang.model.TestUser;
import com.xiangyang.service.UserService;
import com.xiangyang.vo.UserVO;

@RestController
public class userController {
	@Resource
	private UserService userService;
	
	@RequestMapping(path="/hi", method=RequestMethod.GET,produces={"application/json"})
	public UserVO getUser(@RequestParam("userId")String userId){
		TestUser user = userService.getUser(userId);
		UserVO uservo = new UserVO(user.getId(), user.getName(), user.getAge(), user.getEmail(), 
				user.getPhone(), user.getCreateTime(), user.getUpdateTime());
		return uservo;
	}
}
