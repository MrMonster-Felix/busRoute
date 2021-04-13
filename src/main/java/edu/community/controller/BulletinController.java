package edu.community.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.common.util.PageHelper;
import edu.common.util.Result;
import edu.community.bean.Bulletin;
import edu.community.service.BulletinService;

@RestController
@RequestMapping("/bulletin")
@CrossOrigin
public class BulletinController {
    
    @Autowired
    BulletinService service;
    
    /**
     * 获取所有公交信息
     */
    @PostMapping("getListBullrtin")
    public Result getListBulletin(@RequestBody PageHelper page){
        Result r = new Result();
        try{
            r.setData(service.selectBulletin(page));
        }catch(Exception e){
            r.setError("获取公交信息失败");
        }
        return r;
    }
    
    /**
     * 获取某个公交信息
     */
    @GetMapping("/getBulletin")
    public Result getBulletin(Integer id){
        Result r = new Result();
        try{
            r.setData(service.selectByPK(id));
        }catch(Exception e){
            e.printStackTrace();
            r.setError(e.getMessage());
        }        
        return r;
    }

    /**
     * 删除
     */
    @RequestMapping("delBulletin")
    public Result deleteBulletin(Integer id){
        Result r = new Result();
        try{
            r.setData(service.deleteByPK(id));
        }catch(Exception e){
            r.setError("删除失败");
        }       
        return r;
    }
    
    /**
     * 更新
     */
    @RequestMapping("/updateBulletin")
    public Result updateBulletin(Bulletin bulletin){
        Result r = new Result();
        try{
            r.setData(service.updateByPK(bulletin));
        }catch(Exception e){
            r.setError("更新失败！");
        }
        return r;
    }
    
    @PostMapping("insert")
    public Result insertBulletin(Bulletin bulletin){
        Result r = new Result();
        try{
            r.setData(service.insert(bulletin));
        }catch(Exception e){
        	// e.printStackTrace();
            r.setError("线路已存在！");
        }
        return r;
    }
}
