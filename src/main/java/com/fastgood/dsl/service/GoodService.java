package com.fastgood.dsl.service;

import java.util.List;

import com.fastgood.dsl.dto.BrandDto;
import com.fastgood.dsl.dto.CategoryDto;
import com.fastgood.dsl.dto.CountGoodDto;
import com.fastgood.dsl.dto.CountHistoryDto;
import com.fastgood.dsl.dto.GoodDto;

public interface GoodService {
	
	/**
	 * 获取某个品牌所有商品类别对象
	 * @param brandId
	 * @return
	 */
	public List<CategoryDto> selectByBrandId(Integer brandId);
	
	/**
	 * 获取品牌对象
	 * @param id
	 * @return
	 */
	public BrandDto selectBrandById(Integer id);
	
	/**
	 * 获取类别对象
	 * @param categoryId
	 * @return
	 */
	public CategoryDto selectByCategoryId(Long categoryId);
	
	/**
	 * 获取所有品牌对象
	 * @return
	 */
	public List<BrandDto> selectBrandAll();
	
	/**
	 * 获取商品对象
	 * @param id
	 * @return
	 */
	public GoodDto selectGoodById(Long id);
	
	/**
	 * 获取某个用户的所有库存
	 * @param owner
	 * @return
	 */
	public List<CountGoodDto> selectByOwner(Long owner);
	
	/**
	 * 获取用户下某个商品的交易历史记录
	 * @param goodId
	 * @return
	 */
	public List<CountHistoryDto> selectByGoodIdAndOwner(Long goodId, Long owner);
	
	/**
	 * 获取某个用户的所有历史交易记录
	 * @param owner
	 * @return
	 */
	public List<CountHistoryDto> selectHistoryByOwner(Long owner);
}
