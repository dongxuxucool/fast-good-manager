package com.fastgood.dsl.jpa.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.fastgood.dsl.jpa.domain.UserRelationDO;

public interface UserRelationDAO extends CrudRepository<UserRelationDO, Long>{

	public List<UserRelationDO> findByUserId(Long userId);
	
	public List<UserRelationDO> findByUserIdAndRelationType(Long userId, Integer relationType);
	
}
