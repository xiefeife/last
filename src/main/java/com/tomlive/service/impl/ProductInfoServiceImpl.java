package com.tomlive.service.impl;

import java.util.List;
import java.util.Map;

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
	 * 添加产品的方法
	 */
	@Override
	public boolean insertSelective(Map<String, String> map) {
		// TODO Auto-generated method stub
	int count= productInfoMapper.insertSelective(map);
	
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

	
	
	@Override
	public List<ProductInfo> selectProductInfoByCondition(Map<String, String> map) {
		// TODO Auto-generated method stub
	List<ProductInfo>	list=   productInfoMapper.selectProductInfoByCondition(map);
	  if(null!=list) {
		  return list;
	  }
		return null;
	}

	
	
	@Override
	public boolean deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
	int count=	productInfoMapper.deleteByPrimaryKey(id);
		return count>0?true:false;
	}

	/**
	 * 有选择的修改产品信息的方法
	 */
	@Override
	public boolean updateByPrimaryKeySelective(Map<String, String> map) {
		int count=		productInfoMapper.updateByPrimaryKeySelective(map);
		return count>0?true:false;
	}

	
	@Override
	public boolean updateProductInfoStatus(Integer id) {
		       //先根据id查看数据库是否有此用户
		      if(0>selectProductInfoStatus(id)) {  
		    	  //查出来的状态小于0,没有这个用户,直接返回fasle
		    	  return  false;
		         }
		    	  int count =productInfoMapper.updateProductInfoStatus(id);
		    	  return count > 0 ? true : false;
	}

	@Override
	public boolean activeteProductInfoStatus(Integer id) {
		 if(0>selectProductInfoStatus(id)) {  
	    	  //查出来的状态小于0,没有这个用户,直接返回fasle
	    	  return  false;
	         }
		int count =productInfoMapper.updateProductInfoStatus(id);
		return count > 0 ? true : false;
	}

	@Override
	public int selectProductInfoStatus(Integer id) {
		int count =productInfoMapper.updateProductInfoStatus(id);
		return productInfoMapper.selectProductInfoStatus(id);
	}
	
}
