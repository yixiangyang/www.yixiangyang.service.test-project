package com.xiangyang.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.mapping.StatementType;

import com.xiangyang.model.TestUser;

public interface UserMapper {
	
	@Select("SELECT id id,name name,age age,email email,phone phone,create_time createTime,update_time updateTime FROM  test_user WHERE id = #{id}")
	public TestUser getUser(@Param("id") String id);
	
	@SelectKey(keyColumn = "id", before = false, keyProperty = "testUser.id", resultType = String.class, statementType = StatementType.STATEMENT, statement = "SELECT LAST_INSERT_ID() AS id")
	@Insert("insert into test_user (name,age,email,phone,create_time,update_time) VALUES(#{testUser.name},#{testUser.age},#{testUser.email},#{testUser.phone},#{testUser.createTime},#{testUser.updateTime})")
	public int addUser(@Param("testUser") TestUser testUser);
}
