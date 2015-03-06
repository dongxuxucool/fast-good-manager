package com.fastgood.dsl.dto;

import java.util.Date;

public class CountGoodDto {
	
	private Long id;
	
	private Long goodId;
	
	private Date gmtCreate;
	
	private Date gmtModified;
	
	private Long remain;
	
	private Long owner;
	
	private String name;
	
	private String info;
	
	public void setId(Long id){
		this.id = id;
	}
	
	public Long getId(){
		return id;
	}
	
	public void setGoodId(Long goodId){
		this.goodId = goodId;
	}
	
	public Long getGoodId(){
		return goodId;
	}
	
	public void setGmtCreate(Date gmtCreate){
		this.gmtCreate = gmtCreate;
	}
	
	public Date getGmtCreate(){
		return gmtCreate;
	}
	
	public void setGmtModified(Date gmtModified){
		this.gmtModified = gmtModified;
	}
	
	public Date getGmtModified(){
		return gmtModified;
	}
	
	public void setRemain(Long remain){
		this.remain = remain;
	}
	
	public Long getRemain(){
		return remain;
	}
	
	public void setOwner(Long owner){
		this.owner = owner;
	}
	
	public Long getOwner(){
		return owner;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}
	
}

