package com.tomlive.service;

import java.util.List;
import java.util.Map;

import com.tomlive.entity.ProductType;

public interface ProductTypeService {

	
	List<ProductType> selectAllProductType();
	
	boolean insertSelective(Map<String, String> map);
	boolean   deleteByPrimaryKey(Integer id);
	boolean  updateByPrimaryKeySelective(Map<String, Object> map);
}
