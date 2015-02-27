package com.fastgood.web.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

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
import com.fastgood.dsl.util.ArrayListUtil;
import com.fastgood.dsl.util.Constants;

@Controller
@RequestMapping("/partner")
public class PartnerController {

	private static Logger log = LoggerFactory.getLogger(PartnerController.class);
	
	@Autowired
	private UserService userService;
	
	@Autowired
    private HttpSession session;
	
	/**
	 * 获取所有合作伙伴
	 * @return
	 */
	@RequestMapping(value="", method = RequestMethod.GET)
	@ResponseBody
	public AjaxResult<List<UserRelationDto>> partnersGet(){
		Long userId = getCurrentUserId();
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
		Long userId = getCurrentUserId();
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
	 * 获取合作门店信息
	 * @return
	 */
	@RequestMapping(value="/{store_id}/store", method = RequestMethod.GET)
	@ResponseBody
	public AjaxResult<List<UserRelationDto>> storeGet(@PathVariable("store_id")Long storeId){
		Long userId = getCurrentUserId();
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
		Long userId = getCurrentUserId();
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
	 * 获取合作经销商信息
	 * @return
	 */
	@RequestMapping(value="/{agent_id}/agent", method = RequestMethod.GET)
	@ResponseBody
	public AjaxResult<List<UserRelationDto>> agentGet(@PathVariable("agent_id")Long agentId){
		Long userId = getCurrentUserId();
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
		Long userId = getCurrentUserId();
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
	 * 获取合作厂商信息
	 * @return
	 */
	@RequestMapping(value="/{factory_id}/factory", method = RequestMethod.GET)
	@ResponseBody
	public AjaxResult<List<UserRelationDto>> factoryGet(@PathVariable("factory_id")Long factoryId){
		Long userId = getCurrentUserId();
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
	 * 获取当前登录userId
	 * @return
	 */
	private Long getCurrentUserId(){
		Long userId = (Long)session.getAttribute("user_id");
		return userId;
	}
}
