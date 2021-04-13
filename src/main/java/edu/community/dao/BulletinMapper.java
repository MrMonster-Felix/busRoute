package edu.community.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import edu.common.util.PageHelper;
import edu.community.bean.Bulletin;

@Mapper
public interface BulletinMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Bulletin record);

    int insertSelective(Bulletin record);

    Bulletin selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Bulletin record);

    int updateByPrimaryKey(Bulletin record);
    

    List<Bulletin> selectBulletin(PageHelper page);
    
    int count();
}