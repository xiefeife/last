package com.tomlive.dao;

import java.util.List;
import java.util.Map;

import com.tomlive.entity.ProductType;

public interface ProductTypeMapper {

	
	List<ProductType>  selectAllProductType();
	
	int insertSelective(Map<String, String> map);
	
	int  deleteByPrimaryKey(Integer id);
	int  updateByPrimaryKeySelective(Map<String, Object> map);
	
}
