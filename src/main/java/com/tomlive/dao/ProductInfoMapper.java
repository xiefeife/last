package com.tomlive.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.tomlive.entity.ProductInfo;

public interface ProductInfoMapper {

	/**
	 * 根据主键id删除用户
	 * 
	 * @param id
	 * @return
	 */
	int deleteByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(Map<String, String> map);

	List<ProductInfo> selectAllProductInfo();

	/**
	 * 有选择的添加产品
	 * 
	 * @param record
	 * @return
	 */
	int insertSelective(Map<String, String> map);

	/**
	 * 查看多少产品信息的方�?
	 * 
	 * @return 受影响的行数
	 */
	int selectProductInfoCount();

	/**
	 * 根据条件查看产品信息
	 * 
	 * @return
	 */
	List<ProductInfo> selectProductInfoByCondition(Map<String, String> map);

	/**
	 * 撤回产品
	 * 
	 * @param id
	 * @return
	 */
	int updateProductInfoStatus(Integer id);

	/**
	 * 发布产品
	 * 
	 * @param id
	 * @return
	 */
	int activeteProductInfoStatus(Integer id);

	/**
	 * 根据id查看产品状态
	 * 
	 * @param id
	 * @return
	 */
	int selectProductInfoStatus(Integer id);

}