package com.fastgood.dsl.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fastgood.dsl.dto.BrandDto;
import com.fastgood.dsl.dto.CategoryDto;
import com.fastgood.dsl.dto.CountDto;
import com.fastgood.dsl.dto.CountHistoryDto;
import com.fastgood.dsl.dto.GoodDto;
import com.fastgood.dsl.jpa.dao.BrandDAO;
import com.fastgood.dsl.jpa.dao.CategoryDAO;
import com.fastgood.dsl.jpa.dao.CountDAO;
import com.fastgood.dsl.jpa.dao.CountHistoryDAO;
import com.fastgood.dsl.jpa.dao.GoodDAO;
import com.fastgood.dsl.jpa.domain.BrandDO;
import com.fastgood.dsl.jpa.domain.CategoryDO;
import com.fastgood.dsl.jpa.domain.CountDO;
import com.fastgood.dsl.jpa.domain.CountHistoryDO;
import com.fastgood.dsl.jpa.domain.GoodDO;
import com.fastgood.dsl.service.GoodService;
import com.fastgood.dsl.util.ArrayListUtil;

@Component("GoodService")
public class GoodServiceImpl implements GoodService{

	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private BrandDAO brandDAO;
	
	@Autowired
	private GoodDAO goodDAO;
	
	@Autowired
	private CountDAO countDAO;
	
	@Autowired
	private CountHistoryDAO countHistoryDAO;
	
	@Override
	public List<CategoryDto> selectByBrandId(Integer brandId) {
		List<CategoryDO> categoryDOs = categoryDAO.findByBrandId(brandId);
		if(ArrayListUtil.isBlank(categoryDOs)) return null;
		return toCategoryDtos(categoryDOs);
	}

	@Override
	public BrandDto selectBrandById(Integer id) {
		BrandDO brandDO = brandDAO.findOne(id);
		if(brandDO == null) return null;
		return toDto(brandDO);
	}

	@Override
	public List<BrandDto> selectBrandAll() {
		Iterable<BrandDO> brandDOs = brandDAO.findAll();
		if(brandDOs == null) return null;
		List<BrandDto> brands = new ArrayList<BrandDto>();
		for (BrandDO brandDO : brandDOs) {
			brands.add(toDto(brandDO));
		}
		return brands;
	}

	@Override
	public GoodDto selectGoodById(Long id) {
		GoodDO goodDO = goodDAO.findOne(id);
		if(goodDO == null) return null;
		
		return toDto(goodDO);
	}

	@Override
	public List<CountDto> selectByOwner(Long owner) {
		List<CountDO> countDOs = countDAO.findByOwner(owner);
		if(ArrayListUtil.isBlank(countDOs)) return null;
		return toCountDtos(countDOs);
	}

	@Override
	public List<CountHistoryDto> selectByGoodIdAndOwner(Long goodId, Long owner) {
		List<CountHistoryDO> countHistoryDOs = countHistoryDAO.findByGoodIdAndOwner(goodId, owner);
		if(ArrayListUtil.isBlank(countHistoryDOs)) return null;
		return toCountHistoryDtos(countHistoryDOs);
	}

	@Override
	public List<CountHistoryDto> selectHistoryByOwner(Long owner) {
		List<CountHistoryDO> countHistoryDOs = countHistoryDAO.findByOwner(owner);
		if(ArrayListUtil.isBlank(countHistoryDOs)) return null;
		return toCountHistoryDtos(countHistoryDOs);
	}
	
	private CategoryDto toDto(CategoryDO categoryDO){
		CategoryDto category = new CategoryDto();
		category.setBrandId(categoryDO.getBrandId());
		category.setId(categoryDO.getId());
		category.setInfo(categoryDO.getInfo());
		category.setName(categoryDO.getName());
		return category;
	}

	private CategoryDO toDO(CategoryDto categoryDto){
		CategoryDO category = new CategoryDO();
		category.setBrandId(categoryDto.getBrandId());
		category.setId(categoryDto.getId());
		category.setInfo(categoryDto.getInfo());
		category.setName(categoryDto.getName());
		return category;
	}
	
	private BrandDto toDto(BrandDO brandDO){
		BrandDto brand = new BrandDto();
		brand.setId(brandDO.getId());
		brand.setInfo(brandDO.getInfo());
		brand.setName(brandDO.getName());
		return brand;
	}
	
	private GoodDto toDto(GoodDO goodDO){
		GoodDto good = new GoodDto();
		good.setBrandId(goodDO.getBrandId());
		good.setCategoryId(goodDO.getCategoryId());
		good.setId(goodDO.getId());
		good.setInfo(goodDO.getInfo());
		good.setName(goodDO.getName());
		return good;
	}
	
	private CountDto toDto(CountDO countDO){
		CountDto count = new CountDto();
		count.setGmtCreate(countDO.getGmtCreate());
		count.setGmtModified(countDO.getGmtModified());
		count.setGoodId(countDO.getGoodId());
		count.setId(countDO.getId());
		count.setOwner(countDO.getOwner());
		count.setRemain(countDO.getRemain());
		return count;
	}
	
	private CountHistoryDto toDto(CountHistoryDO countHistoryDO){
		CountHistoryDto countHistory = new CountHistoryDto();
		countHistory.setGmtCreate(countHistoryDO.getGmtCreate());
		countHistory.setGoodId(countHistoryDO.getGoodId());
		countHistory.setGoodNum(countHistoryDO.getGoodNum());
		countHistory.setId(countHistoryDO.getId());
		countHistory.setRelationId(countHistory.getRelationId());
		countHistory.setTradeType(countHistory.getTradeType());
		return countHistory;
	}
	
	private List<CountHistoryDto> toCountHistoryDtos(List<CountHistoryDO> countHistoryDOs){
		List<CountHistoryDto> countHistorys = new ArrayList<CountHistoryDto>();
		for (CountHistoryDO countHistoryDO : countHistoryDOs) {
			countHistorys.add(toDto(countHistoryDO));
		}
		return countHistorys;
	}
	
	private List<CountDto> toCountDtos(List<CountDO> countDOs){
		List<CountDto> counts = new ArrayList<CountDto>();
		for (CountDO count : countDOs) {
			counts.add(toDto(count));
		}
		return counts;
	}
	
	private List<CategoryDto> toCategoryDtos(List<CategoryDO> categoryDOs){
		List<CategoryDto> categorys = new ArrayList<CategoryDto>();
		for (CategoryDO category : categoryDOs) {
			categorys.add(toDto(category));
		}
		return categorys;
	}
}
