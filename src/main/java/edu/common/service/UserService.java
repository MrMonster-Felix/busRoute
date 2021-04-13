package edu.common.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import edu.common.bean.User;
import edu.common.bean.Menu;
import edu.common.bean.Role;
import edu.common.dao.UserDao;
import edu.common.util.Result;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserDao dao;
	
	public Map getMenus(User user) throws Exception{
		Role role = dao.selectRoleByUser(user);
		List<Menu> menus = dao.selectMenusByRole(role);
		Map<Integer,Menu> menuMap = new HashMap<Integer,Menu>();
		for(Menu m:menus) {
			if(m.getParentId()==0) {
				menuMap.put(m.getId(),m);
			}else {
				Menu mm = menuMap.get(m.getParentId());
				if(mm.getChildMenu()==null)mm.setChildMenu(new HashMap<Integer,Menu>());
				mm.getChildMenu().put(m.getId(),m);
			}
		}
		return menuMap;
	}
	
    public List<User> getUser(User user)throws Exception{
        Role role = dao.selectRoleByUser(user);
        List<User> list = dao.selectUserByRole(role);
        return list;
    }
	
    public Integer updateUser(User user)throws Exception{
        return dao.updateUser(user);
    }
    
    public Integer deleteUser(User user)throws Exception{
        return dao.deleteUser(user);
    }
    
    public Integer addUser(User user)throws Exception{
        return dao.addUser(user);
    }
    
    public List<User> getUsers()throws Exception{
        return dao.getUsers();
    }
    
	public Result login(User user,HttpServletRequest request) {
		//创建返回对象
		Result result = new Result();
		result.setSuccess(true);
		User u = null;
		try {
			//通过用户名查询用户
			u = dao.login(user.getUsername());
		}catch(Exception e) {
			//服务器异常处理
			result.setSuccess(false);
			result.setCode(500);
			result.setMessage("服务器错误");
			return result;
		}
		//判断用户是否存在
		if(u!=null) {
			//判断密码是否为空
			if(StringUtils.isEmpty(user.getPassword())) {
				result.setCode(500);
				result.setMessage("请输入密码");
				return result;
			}
			//判断密码是否一致
			if(user.getPassword().equals(u.getPassword())) {
				result.setCode(1);
				result.setMessage("登录成功");
				result.setData(u);
				request.getSession().setAttribute(u.getId()+"", u);
				return result;
			}
			//密码错误的情况
			result.setCode(2);
			result.setMessage("密码错误");
			return result;
		}
		//用户不存在的情况
		result.setCode(0);
		result.setMessage("用户名错误");
		return result;
	}

}
