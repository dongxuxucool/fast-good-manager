package com.fastgood.dsl.jpa.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="fm_count_history")
public class CountHistoryDO {
//id,good_id,good_num,out_user_id,in_user_id,gmt_create
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable=false,name="good_id")
	private Long goodId;
	
	@Column(nullable=false,name="good_num")
	private Long goodNum;
	
	@Column(nullable=false,name="trade_type")
	private Integer tradeType;
	
	@Column(nullable=false,name="relation_id")
	private Long relationId;
	
	@Column(nullable=false,name="gmt_create")
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

	public void setOutUserId(Integer tradeType) {
		this.tradeType = tradeType;
	}

	public Long getRelationId() {
		return relationId;
	}

	public void setInUserId(Long relationId) {
		this.relationId = relationId;
	}

	public Date getGmtCreate() {
		return gmtCreate;
	}

	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}
	
}
