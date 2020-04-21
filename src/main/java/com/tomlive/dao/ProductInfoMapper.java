package com.tomlive.dao;

import java.util.List;

import com.tomlive.entity.ProductInfo;

public interface ProductInfoMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(ProductInfo record);

	ProductInfo selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(ProductInfo record);

	int updateByPrimaryKeyWithBLOBs(ProductInfo record);

	int updateByPrimaryKey(ProductInfo record);

	List<ProductInfo> selectAllProductInfo();

	int insertSelective(ProductInfo record);

	/**
	 * 查看多少产品信息的方法
	 * @return  受影响的行数
	 */
	int selectProductInfoCount();
	
	/**
	 * 根据条件查看产品信息
	 * @return
	 */
	List<ProductInfo>  selectProductInfoByCondition();
	
}