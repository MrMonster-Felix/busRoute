package edu.common.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.common.bean.User;
import edu.common.service.UserService;
import edu.common.util.Result;

@RestController
@RequestMapping("/CUser")
@CrossOrigin//解决跨域问题
public class UserController {
    
    @Autowired
    UserService userService;
    
    @GetMapping("/getUserRole")
    public Result getUserRole(User user){
        Result r = new Result();
        try{
            r.setData(userService.getMenus(user));
        }catch(Exception e){
            r.setError("获取菜单失败");
        }
        return r;
    }
    
    @PostMapping("/login")
    public Result login(User user,HttpServletRequest request){
            return userService.login(user, request);
    }
    
    @GetMapping("/getUser")
    public Result getUser(){
        Result r = new Result();
        try{
            r.setData(userService.getUsers());
        }catch(Exception e){
            r.setError("获取用户列表失败");
        }        
        return r;
    }
    
    @PostMapping("/updateUser")
    public Result updateUser(User user){
        Result r = new Result();
        try{
            r.setData(userService.updateUser(user));
        }catch(Exception e){
            r.setError("更新失败");
        }
        return r;
    }
    
    @PostMapping("/deleteUser")
    public Result deleteUser(User user){
        Result r = new Result();
        try{
            r.setData(userService.deleteUser(user));
        }catch(Exception e){
            
            r.setError("删除失败");
        }
        return r;
    }
    
    @PostMapping("/addUser")
    public Result addUser(User user){
        Result r = new Result();
        try{
            r.setData(userService.addUser(user));
        }catch(Exception e){
        	// e.printStackTrace();
            r.setError("用户名已存在");
            
        }
        return r;
    }
    
}
