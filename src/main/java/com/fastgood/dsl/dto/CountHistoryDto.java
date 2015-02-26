package com.fastgood.dsl.dto;

import java.util.Date;

public class CountHistoryDto {
//id,good_id,good_num,out_user_id,in_user_id,gmt_create
	private Long id;
	
	private Long goodId;
	
	private Long goodNum;

	private Integer tradeType;
	
	private Long relationId;
	
	private Date gmtCreate;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getGoodId() {
		return goodId;
	}

	public void setGoodId(Long goodId) {
		this.goodId = goodId;
	}

	public Long getGoodNum() {
		return goodNum;
	}

	public void setGoodNum(Long goodNum) {
		this.goodNum = goodNum;
	}

	public Integer getTradeType() {
		return tradeType;
	}

	public void setTradeType(Integer tradeType) {
		this.tradeType = tradeType;
	}

	public Long getRelationId() {
		return relationId;
	}

	public void setRelationId(Long relationId) {
		this.relationId = relationId;
	}

	public Date getGmtCreate() {
		return gmtCreate;
	}

	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}
	
}
