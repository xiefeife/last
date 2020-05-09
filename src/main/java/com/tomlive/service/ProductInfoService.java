package com.tomlive.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.tomlive.entity.ProductInfo;

/**
 * 产品信息业务逻辑层接口
 * 
 * @author Xie
 * @date2020年4月17日
 */
public interface ProductInfoService {

	List<ProductInfo> selectAllProductInfo();

	/**
	 * 添加产品信息
	 * 
	 * @param record
	 * @return
	 */
	boolean insertSelective(Map<String, String> map);

	/**
	 * 查看多少产品信息的方法
	 * 
	 * @return 受影响的行数
	 */
	int selectProductInfoCount();

	List<ProductInfo> selectProductInfoByCondition(Map<String, String> map);

	/**
	 * 根据主键id删除
	 * 
	 * @param id
	 * @return
	 */
	boolean deleteByPrimaryKey(Integer id);

	/**
	 * 修改产品信息
	 * 
	 * @param map
	 * @return
	 */
	boolean updateByPrimaryKeySelective(Map<String, String> map);

	/**
	 * 撤回新闻状态
	 * 
	 * @param id
	 * @return
	 */
	boolean updateProductInfoStatus(Integer id);

	/**
	 * 激活新闻状态
	 * 
	 * @param id
	 * @return
	 */
	boolean activeteProductInfoStatus(Integer id);

	/**
	 * 根据主键查找新闻状态
	 * 
	 * @param id
	 * @return
	 */
	int selectProductInfoStatus(Integer id);

}
