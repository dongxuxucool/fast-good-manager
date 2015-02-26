package com.fastgood.dsl.service;

import java.util.List;

import com.fastgood.dsl.dto.UserDto;
import com.fastgood.dsl.dto.UserRelationDto;

public interface UserService {
	
	/**
	 * 保存用户
	 * @param user
	 * @return
	 */
	public long save(String email, String password, String companyName, Integer type);
	
	/**
	 * 修改密码
	 * @param email
	 * @param password
	 * @return
	 */
	public boolean changePassword(Integer id,String oldPassword,String newPassword);
	
	/**
	 * 验证邮箱是否存在
	 * @param email
	 * @return
	 */
	public boolean exists(String email);
	
	/**
	 * 登录
	 * @param email
	 * @param password
	 * @return
	 */
	public Long login(String email,String password);
	
	/**
	 * 根据邮箱获取用户对象
	 * @param email
	 * @return
	 */
	public UserDto selectByEmail(String email);
		
	/**
	 * 根据Id获取用户对象
	 * @param userId
	 * @return
	 */
	public UserDto selectById(Long userId);
	
	/**
	 * 获取用户所有关联用户群
	 * @param userId
	 * @return
	 */
	public List<UserRelationDto> selectByUserId(Long userId);

}
