package com.fastgood.dsl.jpa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="fm_good")
public class GoodDO {
//id,name,category_id,brand_id,info
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable=false,length=128)
	private String name;
	
	@Column(nullable=false,name="category_id")
	private Long categoryId;
	
	@Column(nullable=false,name="brand_id")
	private Long brandId;
	
	@Column(nullable=false,name="info",length=256)
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
}
