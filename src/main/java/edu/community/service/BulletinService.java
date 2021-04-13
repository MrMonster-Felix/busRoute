package edu.community.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.common.util.PageHelper;
import edu.community.bean.Bulletin;
import edu.community.dao.BulletinMapper;

@Service
@Transactional
public class BulletinService {
    
    @Autowired
    BulletinMapper dao;
    
    
    /**
     * 查询所有
     */
    public PageHelper selectBulletin(PageHelper page)throws Exception{
        page.setTotalCount(dao.count());
        page.setData(dao.selectBulletin(page));
        return page;
    }
    
    /**
     * 查看单个
     */
    public Bulletin selectByPK(int id)throws Exception{
        return dao.selectByPrimaryKey(id);
    }
    
    /**
     * 删除
     */
    public int deleteByPK(Integer id){
        return dao.deleteByPrimaryKey(id);
    }
    
    /**
     * 更新
     */
    public int updateByPK(Bulletin bulletin){
        return dao.updateByPrimaryKeySelective(bulletin);
    }
    
    public int insert(Bulletin bulletin){
        return dao.insert(bulletin);
    }
}
