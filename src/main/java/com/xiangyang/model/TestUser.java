package com.xiangyang.model;

import java.sql.Timestamp;

public class TestUser {
	private String id;
	private String name;
	private String age;
	private String email;
	private String phone;
	private Timestamp createTime;
	private Timestamp updateTime;
	
	public TestUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TestUser( String name, String age, String email, String phone) {
		super();
		this.name = name;
		this.age = age;
		this.email = email;
		this.phone = phone;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}
	
}
