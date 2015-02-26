package com.fastgood.dsl.jpa.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="fm_user")
public class UserDO {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable=false,name="type")
	private Integer type; 
	
	@Column(nullable=false,length=128)
	private String email; 
	
	@Column(nullable=false,length=128)
	private String password; 
	
	@Column(nullable=false,length=256)
	private String name; 
	
	@Column(nullable=false,length=256,name="company_name")
	private String companyName; 
	
	@Column(nullable=false,length=32)
	private String mobile; 
	
	@Column(nullable=false,name="regist_date")
	private Date registDate; 
	
	@Column(nullable=false,name="last_login")
	private Date lastLogin;
	
	@Column(nullable=false,name="is_active")
	private Integer isActive;
	
	public void setId(Long id){
		this.id = id;
	}
	
	public Long getId(){
		return id;
	}
	
	public void setType(Integer type){
		this.type = type;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Date getRegistDate() {
		return registDate;
	}

	public void setRegistDate(Date registDate) {
		this.registDate = registDate;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public Integer getIsActive() {
		return isActive;
	}

	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}
	
	public void setCompanyName(String companyName){
		this.companyName = companyName;
	}
	
	public String getCompanyName(){
		return companyName;
	}
}
