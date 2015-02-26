package com.fastgood.dsl.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fastgood.dsl.dto.UserDto;
import com.fastgood.dsl.dto.UserRelationDto;
import com.fastgood.dsl.jpa.dao.UserDAO;
import com.fastgood.dsl.jpa.dao.UserRelationDAO;
import com.fastgood.dsl.jpa.domain.UserDO;
import com.fastgood.dsl.service.UserService;

@Component("UserService")
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private UserRelationDAO userRelationDAO;
	
	@Override
	public long save(String email, String password, String companyName, Integer type) {
		UserDO user = new UserDO();
		user.setId(null);
		user.setEmail(email);
		user.setPassword(password);
		user.setCompanyName(companyName);
		user.setIsActive(0);
		user.setMobile("");
		user.setName(email);
		user.setRegistDate(new Date());
		user.setType(type);
		user.setLastLogin(new Date());
		userDAO.save(user);
		return 0;
	}

	@Override
	public boolean changePassword(Integer id, String oldPassword,
			String newPassword) {
		return false;
	}

	@Override
	public boolean exists(String email) {
		UserDO user = userDAO.findByEmail(email);
		if(user!=null) return true;
		return false;
	}

	@Override
	public Long login(String email, String password) {
		UserDO user = userDAO.findByEmailAndPassword(email,password);
		if(user==null)
			return 0L;
		return user.getId();
	}

	@Override
	public UserDto selectByEmail(String email) {
		return null;
	}

	@Override
	public UserDto selectById(Long userId) {
		return null;
	}

	@Override
	public List<UserRelationDto> selectByUserId(Long userId) {
		return null;
	}

}
