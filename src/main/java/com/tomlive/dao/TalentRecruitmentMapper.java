package com.tomlive.dao;

import java.util.List;

import com.tomlive.entity.TalentRecruitment;

public interface TalentRecruitmentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TalentRecruitment record);

    /**
     * 选择性的添加岗位招聘的方法
     * @param record  人才招聘的对象
     * @return   受影响的行数
     */
    int insertSelective(TalentRecruitment record);

    
    
    List<TalentRecruitment> selectAllTalentRecruitment();
    
    /**
     * 统计岗位招聘的数量
     * @return  受影响的行数
     */
    int  selectTalentRecruitmentCount();
    
    
    
    /**
    * 统计每个岗位的招聘数量
     * @return
     */
    List<TalentRecruitment> selectSizeGroupBy();
}