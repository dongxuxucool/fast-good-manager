package com.fastgood.dsl.jpa.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.fastgood.dsl.jpa.domain.CountDO;
import com.fastgood.dsl.jpa.domain.CountHistoryDO;

public interface CountHistoryDAO extends CrudRepository<CountDO, Long>{

	public List<CountHistoryDO> findByGoodIdAndOwner(Long goodId, Long owner);
	
	public List<CountHistoryDO> findByOwner(Long owner);
}
