package com.tomlive.service.impl;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tomlive.dao.ProductInfoMapper;
import com.tomlive.entity.ProductInfo;
import com.tomlive.service.ProductInfoService;

@Service
@Transactional
public class ProductInfoServiceImpl implements ProductInfoService{

	@Autowired
	private  ProductInfoMapper productInfoMapper;
	
	@Override
	public List<ProductInfo> selectAllProductInfo() {
		
		return productInfoMapper.selectAllProductInfo();
	}

	/**
	 * 有选择的添加新闻中心的方法
	 */
	@Override
	public Boolean insertSelective(ProductInfo record) {
		// TODO Auto-generated method stub
	int count= productInfoMapper.insertSelective(record);
	
	
		return count>0?true:false;
	}
	
	/**
	 * 查看多少产品信息的方法
	 * @return  受影响的行数
	 */
	@Override
	public int selectProductInfoCount() {
		
	  int count=	productInfoMapper.selectProductInfoCount();
	
	  return count;
			 
	}
	
}
