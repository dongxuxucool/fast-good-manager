package com.dxx.fastgood.jpa.dao;

import org.springframework.data.repository.CrudRepository;

import com.dxx.fastgood.jpa.domain.UserDO;

public interface UserDAO extends CrudRepository<UserDO, Long>{

		
}
