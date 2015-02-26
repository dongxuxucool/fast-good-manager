package com.fastgood.dsl.jpa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="fm_good_brand")
public class BrandDO {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(nullable=false,length=128)
	private String name;
	
	@Column(nullable=false,name="info",length=256)
	private String info;
	
	public void setId(Integer id){
		this.id = id;
	}
	
	public Integer getId(){
		return id;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
	public void setInfo(String info){
		this.info = info;
	}
	
	public String getInfo(){
		return info;
	}
}
