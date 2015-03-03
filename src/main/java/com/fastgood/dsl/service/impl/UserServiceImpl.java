package com.fastgood.dsl.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fastgood.dsl.dto.UserDto;
import com.fastgood.dsl.dto.UserRelationDto;
import com.fastgood.dsl.jpa.dao.UserDAO;
import com.fastgood.dsl.jpa.dao.UserRelationDAO;
import com.fastgood.dsl.jpa.domain.UserDO;
import com.fastgood.dsl.jpa.domain.UserRelationDO;
import com.fastgood.dsl.service.UserService;
import com.fastgood.dsl.util.ArrayListUtil;

@Component("UserService")
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private UserRelationDAO userRelationDAO;
	
	@Autowired
	private HttpSession session;
	
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
		List<UserRelationDO> userRelDOs = userRelationDAO.findByUserId(userId);
		if(ArrayListUtil.isBlank(userRelDOs)) return null;
		
		return toUserRelDtos(userRelDOs);
	}
	
	@Override
	public List<UserRelationDto> selectByUserIdAndRelationType(Long userId,
			Integer relationType) {
		List<UserRelationDO> userRelDOs = userRelationDAO.findByUserIdAndRelationType(userId, relationType);
		if(ArrayListUtil.isBlank(userRelDOs)) return null;
		
		return toUserRelDtos(userRelDOs);
	}

	private UserRelationDto toDto(UserRelationDO userRelationDO){
		UserRelationDto userRelation = new UserRelationDto();
		userRelation.setCompanyName(userRelationDO.getCompanyName());
		userRelation.setGmtCreate(userRelationDO.getGmtCreate());
		userRelation.setId(userRelationDO.getId());
		userRelation.setRelationId(userRelationDO.getRelationId());
		userRelation.setRelationType(userRelationDO.getRelationType());
		userRelation.setType(userRelationDO.getType());
		userRelation.setUserId(userRelationDO.getUserId());
		return userRelation;
	}

	private List<UserRelationDto> toUserRelDtos(List<UserRelationDO> userRelDOs){
		List<UserRelationDto> userRels = new ArrayList<UserRelationDto>();
		for (UserRelationDO userRel : userRelDOs) {
			userRels.add(toDto(userRel));
		}
		return userRels;
	}

	@Override
	public Long getCurrentUserId() {
		Long userId = (Long)session.getAttribute("user_id");
		return userId;
	}
}
