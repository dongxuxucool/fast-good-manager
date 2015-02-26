package com.fastgood.dsl.jpa.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.fastgood.dsl.jpa.domain.CountDO;

public interface CountDAO extends CrudRepository<CountDO, Long>{

	public List<CountDO> findByOwner(Long owner);
	
}
