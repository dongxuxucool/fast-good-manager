package com.dxx.fastgood.service;

import com.dxx.fastgood.dto.UserDto;

public interface UserService {
	
	/**
	 * 新建用户
	 * @param user
	 * @return
	 */
	public long save(String email, String password);
	
	/**
	 * 修改密码
	 * @param email
	 * @param password
	 * @return
	 */
	public boolean changePassword(Integer id,String oldPassword,String newPassword);
	
	/**
	 * 验证用户是否存在
	 * @param email
	 * @return
	 */
	public boolean exists(String email);
	
	/**
	 * 用户登录验证
	 * @param email
	 * @param password
	 * @return
	 */
	public Long login(String email,String password);
	
	/**
	 * 获取用户对象
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
	
//	public selectBy

}
