package com.fastgood.dsl.jpa.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="fm_user_relation")
public class UserRelationDO {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable=false,name="user_id")
	private Long userId;
	
	@Column(nullable=false,name="type")
	private Integer type;
	
	@Column(nullable=false,name="relation_id")
	private Long relationId;
	
	@Column(nullable=false,name="relation_type")
	private Integer relationType;
	
	@Column(nullable=false,name="gmt_create")
	private Date gmtCreate;
	
	@Column(nullable=false,name="company_name")
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

