package com.xiangyang.model;

public class Customer extends Object{
	/**客户id*/
	private String id;
	/**客户名字*/
	private String name;
	/**联系人*/
	private String lperson;
	/**联系电话*/
	private String phone;
	/**客户类型，QY企业类型、PE个人类型*/
	private String type;
	/**所属行业代码*/
	private String industryCode;
	/**行业备注*/
	private String industryName;
	/**客户来源渠道类型，SM上门、ZJ中介、TJ老客户推荐、NT互联网、ET其他*/
	private String channelType;
	/**客户来源渠道名称*/
	private String channelName;
	/**客户备注*/
	private String memo;
	/**租户id*/
	private String tenantId;
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
	public String getLperson() {
		return lperson;
	}
	public void setLperson(String lperson) {
		this.lperson = lperson;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getIndustryCode() {
		return industryCode;
	}
	public void setIndustryCode(String industryCode) {
		this.industryCode = industryCode;
	}
	public String getIndustryName() {
		return industryName;
	}
	public void setIndustryName(String industryName) {
		this.industryName = industryName;
	}
	public String getChannelType() {
		return channelType;
	}
	public void setChannelType(String channelType) {
		this.channelType = channelType;
	}
	public String getChannelName() {
		return channelName;
	}
	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public String getTenantId() {
		return tenantId;
	}
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}
	public Customer(String id, String name, String lperson, String phone, String type, String industryCode,
			String industryName, String channelType, String channelName, String memo, String tenantId) {
		super();
		this.id = id;
		this.name = name;
		this.lperson = lperson;
		this.phone = phone;
		this.type = type;
		this.industryCode = industryCode;
		this.industryName = industryName;
		this.channelType = channelType;
		this.channelName = channelName;
		this.memo = memo;
		this.tenantId = tenantId;
	}
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", lperson=" + lperson + ", phone=" + phone + ", type=" + type
				+ ", industryCode=" + industryCode + ", industryName=" + industryName + ", channelType=" + channelType
				+ ", channelName=" + channelName + ", memo=" + memo + ", tenantId=" + tenantId + "]";
	}
	
}
