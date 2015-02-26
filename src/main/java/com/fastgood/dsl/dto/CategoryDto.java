package com.fastgood.dsl.dto;

public class CategoryDto {
	
	private Long id;
	
	private String name;
	
	private Long brandId;
	
	private String info;
	
	public void setId(Long id){
		this.id = id;
	}
	
	public Long getId(){
		return id;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
	public void setBrandId(Long brandId){
		this.brandId = brandId;
	}
	
	public Long getBrandId(){
		return brandId;
	}
	
	public void setInfo(String info){
		this.info = info;
	}
	
	public String getInfo(){
		return info;
	}
}
