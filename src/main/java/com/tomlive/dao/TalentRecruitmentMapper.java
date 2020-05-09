package com.tomlive.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.tomlive.entity.TalentRecruitment;

public interface TalentRecruitmentMapper {
	/**
	 * 删除操作
	 * @param id
	 * @return
	 */
    int deleteByPrimaryKey(Integer id);

 

    /**
            * 选择性的添加岗位招聘的方法
     * @param record  人才招聘的对象
     * @return   受影响的行数
     */
    int insertSelective( Map<String, String> map);

    
    /**
     * 查看所有岗位信息
     * @return
     */
    List<TalentRecruitment> selectAllTalentRecruitment();
    
    /**
              * 统计岗位招聘的数量
     * @return  受影响的行数
     */
    List<TalentRecruitment>  selectAllTalentRecruitmentCount();
    
    /**
     * 查看招聘岗位的总数量
* @return
*/
int selectAllTalentRecruitmentSum();


 
List<TalentRecruitment> selectTalentRecruitmentByCondition(Map<String, String> map);
    
    
/**
 * 根据主键有选择的修改岗位信息
 * @param map
 * @return
 */
int  updateByPrimaryKeySelective(Map<String, String> map);
   
    
}