package com.fastgood.web.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fastgood.dsl.dto.UserDto;
import com.fastgood.dsl.dto.UserRelationDto;
import com.fastgood.dsl.service.UserService;
import com.fastgood.dsl.util.AjaxResult;
import com.fastgood.dsl.util.ArrayListUtil;

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
	public AjaxResult<List<UserDto>> partnersGet(){
		Long userId = getCurrentUserId();
    	if(userId == null){
    		return AjaxResult.newErrorResult("用户登录异常，请重新登录");
    	}
    	List<UserRelationDto> partners = userService.selectByUserId(userId);
    	if(ArrayListUtil.isNotBlank(partners)){
	    	for (UserRelationDto userR : partners) {
				
			}
    	}
    	AjaxResult<List<UserDto>> result = new AjaxResult<List<UserDto>>();
    	result.setSuccess(true);
    	result.setData(null);
    	return result;
	}
	
	private Long getCurrentUserId(){
		Long userId = (Long)session.getAttribute("user_id");
		return userId;
	}
}
