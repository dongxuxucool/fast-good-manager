package com.fastgood.dsl.dto;

public class GoodDto {
	private Long id;
	
	private String name;
	
	private Long categoryId;
	
	private Long brandId;
	
	private String info;
	
	private String brandName;
	
	private String caregoryName;
	
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
	
	public void setCategoryId(Long categoryId){
		this.categoryId = categoryId;
	}
	
	public Long getCategoryId(){
		return categoryId;
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

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getCaregoryName() {
		return caregoryName;
	}

	public void setCaregoryName(String caregoryName) {
		this.caregoryName = caregoryName;
	}
	
}
