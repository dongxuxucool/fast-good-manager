package com.fastgood.web.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fastgood.dsl.dto.UserDto;
import com.fastgood.dsl.dto.UserRelationDto;
import com.fastgood.dsl.service.UserService;
import com.fastgood.dsl.util.AjaxResult;
import com.fastgood.dsl.util.Constants;

@Controller
@RequestMapping("/partner")
public class PartnerController {

	private static Logger log = LoggerFactory.getLogger(PartnerController.class);
	
	@Autowired
	private UserService userService;
	
	/**
	 * 获取所有合作伙伴
	 * @return
	 */
	@RequestMapping(value="", method = RequestMethod.GET)
	@ResponseBody
	public AjaxResult<List<UserRelationDto>> partnersGet(){
		Long userId = userService.getCurrentUserId();
    	if(userId == null){
    		return AjaxResult.newErrorResult("用户登录异常，请重新登录");
    	}
    	List<UserRelationDto> partners = userService.selectByUserId(userId);
    	
    	AjaxResult<List<UserRelationDto>> result = new AjaxResult<List<UserRelationDto>>();
    	result.setSuccess(true);
    	result.setData(partners);
    	return result;
	}
	
	/**
	 * 获取所有合作门店
	 * @return
	 */
	@RequestMapping(value="/store", method = RequestMethod.GET)
	@ResponseBody
	public AjaxResult<List<UserRelationDto>> storesGet(){
		Long userId = userService.getCurrentUserId();
    	if(userId == null){
    		return AjaxResult.newErrorResult("用户登录异常，请重新登录");
    	}
    	List<UserRelationDto> partners = userService.selectByUserIdAndRelationType(userId, Constants.FAST_GOOD_STORE);
    	
    	AjaxResult<List<UserRelationDto>> result = new AjaxResult<List<UserRelationDto>>();
    	result.setSuccess(true);
    	result.setData(partners);
    	return result;
	}
	
	/**
	 * 获取所有合作经销商
	 * @return
	 */
	@RequestMapping(value="/agent", method = RequestMethod.GET)
	@ResponseBody
	public AjaxResult<List<UserRelationDto>> agentsGet(){
		Long userId = userService.getCurrentUserId();
    	if(userId == null){
    		return AjaxResult.newErrorResult("用户登录异常，请重新登录");
    	}
    	List<UserRelationDto> partners = userService.selectByUserIdAndRelationType(userId, Constants.FAST_GOOD_AGENT);
    	
    	AjaxResult<List<UserRelationDto>> result = new AjaxResult<List<UserRelationDto>>();
    	result.setSuccess(true);
    	result.setData(partners);
    	return result;
	}
	
	/**
	 * 获取所有合作厂商
	 * @return
	 */
	@RequestMapping(value="/factory", method = RequestMethod.GET)
	@ResponseBody
	public AjaxResult<List<UserRelationDto>> factorysGet(){
		Long userId = userService.getCurrentUserId();
    	if(userId == null){
    		return AjaxResult.newErrorResult("用户登录异常，请重新登录");
    	}
    	List<UserRelationDto> partners = userService.selectByUserIdAndRelationType(userId, Constants.FAST_GOOD_FACTORY);
    	
    	AjaxResult<List<UserRelationDto>> result = new AjaxResult<List<UserRelationDto>>();
    	result.setSuccess(true);
    	result.setData(partners);
    	return result;
	}	

	/**
	 * 获取合作伙伴信息
	 * @return
	 */
	@RequestMapping(value="/{partner_id}", method = RequestMethod.GET)
	@ResponseBody
	public AjaxResult<UserDto> storeGet(@PathVariable("partner_id")Long partnerId){
		Long userId = userService.getCurrentUserId();
    	if(userId == null){
    		return AjaxResult.newErrorResult("用户登录异常，请重新登录");
    	}  	
    	AjaxResult<UserDto> result = new AjaxResult<UserDto>();
    	result.setSuccess(true);
    	result.setData(userInfoFilter(partnerId));
    	return result;
	}
	
	/**
	 * 获取过滤后的用户信息
	 * @param userId
	 * @return
	 */
	private UserDto userInfoFilter(Long userId){
    	UserDto user = userService.selectById(userId);
    	if(user == null) return null;
    	user.setName("");
    	user.setPassword("");
    	user.setRegistDate(null);
    	user.setLastLogin(null);
    	user.setEmail("");
    	return user;
	}

}
