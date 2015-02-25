package com.dxx.fastgood.service;

import com.dxx.fastgood.dto.UserDto;

public interface UserService {
	
	/**
	 * �½��û�
	 * @param user
	 * @return
	 */
	public long save(String email, String password);
	
	/**
	 * �޸�����
	 * @param email
	 * @param password
	 * @return
	 */
	public boolean changePassword(Integer id,String oldPassword,String newPassword);
	
	/**
	 * ��֤�û��Ƿ����
	 * @param email
	 * @return
	 */
	public boolean exists(String email);
	
	/**
	 * �û���¼��֤
	 * @param email
	 * @param password
	 * @return
	 */
	public Long login(String email,String password);
	
	/**
	 * ��ȡ�û�����
	 * @param email
	 * @return
	 */
	public UserDto selectByEmail(String email);
		
	/**
	 * ����Id��ȡ�û�����
	 * @param userId
	 * @return
	 */
	public UserDto selectById(Long userId);
	
//	public selectBy

}
