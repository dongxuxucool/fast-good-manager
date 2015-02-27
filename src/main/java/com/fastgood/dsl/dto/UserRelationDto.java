package com.fastgood.dsl.dto;

import java.util.Date;

public class UserRelationDto {
	
	private Long id;
	
	private Long userId;
	
	private Integer type;
	
	private Long relationId;
	
	private Integer relationType;
	
	private Date gmtCreate;
	
	private String companyName;
	
	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public void setId(Long id){
		this.id = id;
	}
	
	public Long getId(){
		return id;
	}
	
	public void setUserId(Long userId){
		this.userId = userId;
	}
	
	public Long getUserId(){
		return userId;
	}
	
	public void setType(Integer type){
		this.type = type;
	} 
	
	public Integer getType(){
		return type;
	}
	
	public void setRelationId(Long relationId){
		this.relationId = relationId;
	}
	
	public Long getRelationId(){
		return relationId;
	}
	
	public void setRelationType(Integer relationType){
		this.relationType = relationType;
	}
	
	public Integer getRelationType(){
		return relationType;
	}
	
	public void setGmtCreate(Date gmtCreate){
		this.gmtCreate = gmtCreate;
	}
	
	public Date getGmtCreate(){
		return gmtCreate;
	}
}

