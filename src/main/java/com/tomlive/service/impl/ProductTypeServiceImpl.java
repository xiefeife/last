package com.tomlive.service.impl;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tomlive.dao.ProductTypeMapper;
import com.tomlive.entity.ProductType;
import com.tomlive.service.ProductTypeService;
@Transactional
@Service
public class ProductTypeServiceImpl implements ProductTypeService{

	@Autowired
	private ProductTypeMapper productTypeMapper;
	
	@Override
	public List<ProductType> selectAllProductType() {
		
		return productTypeMapper.selectAllProductType();
	}

	
	@Override
	public boolean insertSelective(Map<String, String> map) {
int count=		productTypeMapper.insertSelective(map);
		return count>0?true:false;
	}


	@Override
	public boolean deleteByPrimaryKey(Integer id) {
		int count=	productTypeMapper.deleteByPrimaryKey(id);
		return count>0?true:false;
		}


	@Override
	public boolean updateByPrimaryKeySelective(Map<String, Object> map) {
		
		int count=productTypeMapper.updateByPrimaryKeySelective(map);
		return count>0?true:false;
	}

}
