package com.xiangyang.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.xiangyang.model.TestUser;

public interface UserMapper {
	
	@Select("SELECT name name,age age,email email,phone phone FROM  test_user WHERE id = #{id}")
	public TestUser getUser(@Param("id") String id);
	
	@Insert("insert into test_user (name,age,email,phone,create_time,update_time) VALUES(#{testUser.name},#{testUser.age},#{testUser.email},#{testUser.phone},#{testUser.createTime},#{testUser.updateTime})")
	public void addUser(@Param("testUser") TestUser testUser);
}
