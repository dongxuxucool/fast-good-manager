package com.fastgood.dsl.jpa.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.fastgood.dsl.jpa.domain.CategoryDO;

public interface CategoryDAO extends CrudRepository<CategoryDO, Long>{

	public List<CategoryDO> findByBrandId(Integer brandId);
	
	
}
