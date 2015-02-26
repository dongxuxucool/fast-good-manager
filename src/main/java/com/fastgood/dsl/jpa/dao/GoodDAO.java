package com.fastgood.dsl.jpa.dao;

import org.springframework.data.repository.CrudRepository;

import com.fastgood.dsl.jpa.domain.GoodDO;

public interface GoodDAO extends CrudRepository<GoodDO, Long>{

	
}
