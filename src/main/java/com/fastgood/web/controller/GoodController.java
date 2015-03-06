package com.fastgood.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fastgood.dsl.dto.CountGoodDto;
import com.fastgood.dsl.dto.GoodDto;
import com.fastgood.dsl.jpa.dao.CountDAO;
import com.fastgood.dsl.jpa.domain.CountDO;
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
	
	@Autowired
	private CountDAO countDAO;
	
	/**
	 * Just TEST
	 */	
	@RequestMapping(value="/test", method=RequestMethod.GET)
	@ResponseBody
	public AjaxResult<CountDO> test(){
		CountDO name = countDAO.find(2L);
		AjaxResult<CountDO> result = new AjaxResult<CountDO>();
		result.setSuccess(true);
		result.setData(name);
		return result;
	}
	
	//c.id,c.goodId,c.remain,c.owner,g.name,g.info
	@RequestMapping(value="/test1", method=RequestMethod.GET)
	@ResponseBody
	public AjaxResult<CountGoodDto> test1(){
		String results = countDAO.findByGoodId(2L);
		
		CountGoodDto countGood = new CountGoodDto();
		String[] resultSplits = results.split("\\,");
		countGood.setId(Long.parseLong(resultSplits[0]));
		countGood.setGoodId(Long.parseLong(resultSplits[1]));
		countGood.setRemain(Long.parseLong(resultSplits[2]));
		countGood.setOwner(Long.parseLong(resultSplits[3]));
		countGood.setName(resultSplits[3]);
		countGood.setInfo(resultSplits[4]);
		
		AjaxResult<CountGoodDto> result = new AjaxResult<CountGoodDto>();
		result.setSuccess(true);
		result.setData(countGood);
		return result;
	}

	/**
	 * 获取当前用户所有商品对象
	 * @return
	 */
	@RequestMapping(value="", method=RequestMethod.GET)
	@ResponseBody
	public AjaxResult<List<CountGoodDto>> myGoodsGet(){
		Long userId = userService.getCurrentUserId();
    	if(userId == null){
    		return AjaxResult.newErrorResult("用户登录异常，请重新登录");
    	}  	   	
    	List<CountGoodDto> countGoods = goodService.selectByOwner(userId);
    	
		AjaxResult<List<CountGoodDto>> result = new AjaxResult<List<CountGoodDto>>();
		result.setSuccess(true);
		result.setData(countGoods);
		return result;
	}
	
	/**
	 * 获取商品对象
	 * @param goodId
	 * @return
	 */
	@RequestMapping(value="/{good_id}", method=RequestMethod.GET)
	@ResponseBody
	public AjaxResult<GoodDto> goodGet(@PathVariable("good_id")Long goodId){
		GoodDto good = goodService.selectGoodById(goodId);
		AjaxResult<GoodDto> result = new AjaxResult<GoodDto>();
		result.setSuccess(true);
		result.setData(good);
		return null;
	}
	
	/**
	 * 获取某个用户所有商品对象
	 * @param owner
	 * @return
	 */
	@RequestMapping(value="/good/{owner}", method=RequestMethod.GET)
	@ResponseBody
	public AjaxResult<List<CountGoodDto>> goodsGet(@PathVariable("owner")Long owner){
    	List<CountGoodDto> countGoods = goodService.selectByOwner(owner);
		AjaxResult<List<CountGoodDto>> result = new AjaxResult<List<CountGoodDto>>();
		result.setSuccess(true);
		result.setData(countGoods);
		return result;
	}
}
