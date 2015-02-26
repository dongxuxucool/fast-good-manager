package com.fastgood.dsl.jpa.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="fm_good_count")
public class CountDO {
//id,good_id,first_in(datetime),recent_in(datetime),remain(剩余数量),owner
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable=false,name="good_id")
	private Long goodId;
	
	@Column(nullable=false,name="gmt_create")
	private Date gmtCreate;
	
	@Column(nullable=false,name="gmt_modified")
	private Date gmtModified;
	
	@Column(nullable=false,name="remain")
	private Long remain;
	
	@Column(nullable=false,name="owner")
	private Long owner;
	
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
}

