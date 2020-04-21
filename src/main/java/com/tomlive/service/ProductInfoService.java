package com.tomlive.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.tomlive.entity.ProductInfo;

/**
 * 产品信息业务逻辑层接口
 *  @author Xie
 *  @date2020年4月17日
 */
public interface ProductInfoService {
	
	
	List<ProductInfo>  selectAllProductInfo();
	Boolean  insertSelective(ProductInfo record);
	/**
	 * 查看多少产品信息的方法
	 * @return  受影响的行数
	 */
    int selectProductInfoCount();
    
  
   List<ProductInfo>   selectProductInfoByCondition();
}
