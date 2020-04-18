package com.tomlive.service;

import java.util.List;

import com.tomlive.entity.PressSort;

public interface PressSortService {

	/**
	 * 查看所有新闻分类业务层接口
	 * @return
	 */
	List<PressSort> selectAllPressSort();
}
