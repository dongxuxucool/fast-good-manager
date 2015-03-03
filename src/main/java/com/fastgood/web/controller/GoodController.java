package com.fastgood.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fastgood.dsl.dto.GoodDto;
import com.fastgood.dsl.service.GoodService;
import com.fastgood.dsl.service.UserService;
import com.fastgood.dsl.util.AjaxResult;

@Controller
@RequestMapping("/good")
public class GoodController {

	@Autowired
	private GoodService goodService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="", method=RequestMethod.GET)
	@ResponseBody
	public AjaxResult<List<GoodDto>> goodsGet(){
		Long userId = userService.getCurrentUserId();
    	if(userId == null){
    		return AjaxResult.newErrorResult("用户登录异常，请重新登录");
    	}  	
    	//到此一游
		AjaxResult<List<GoodDto>> result = new AjaxResult<List<GoodDto>>();
		result.setSuccess(true);
		result.setData(null);
		return result;
	}
}
