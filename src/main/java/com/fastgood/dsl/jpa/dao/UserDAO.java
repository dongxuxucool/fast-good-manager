package com.fastgood.dsl.jpa.dao;

import org.springframework.data.repository.CrudRepository;

import com.fastgood.dsl.jpa.domain.UserDO;

public interface UserDAO extends CrudRepository<UserDO, Long>{

	public UserDO findByEmail(String email);
	
	public UserDO findByEmailAndPassword(String email,String password);

}
