package edu.common.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import edu.common.bean.Menu;
import edu.common.bean.Role;
import edu.common.bean.User;



@Mapper
public interface UserDao {

	@Select("select * from users where username=#{username}")
	User login(@Param("username")String username);
	
	@Select("select * from users")
	List<User> getUsers();
	
	@Select("select * from role where id=#{roleid}")
	Role selectRoleByUser(User user);
	
	@Select("select * from menu a left join role_menu b on a.id=b.menuid where b.roleid=#{id} order by a.parentId")
	List<Menu> selectMenusByRole(Role role);
	
	@Select("select * from users u where u.roleid in (select id from role where role =#{role}")
	List<User> selectUserByRole(Role role);
	
	@Update("UPDATE users SET username=#{username}, password=#{password} ,name=#{name} ,updatetime=SYSDATE() where id = #{id}")
//	@Update("UPDATE users SET username=#{username}, password=#{password} ,name=#{name} ,updatetime=SYSDATE(),roleid=#{roleid} where id = #{id}")
	Integer updateUser(User user);
	
	@Delete("delete from users where id = #{id}")
	Integer deleteUser(User user);
	
	@Insert("INSERT INTO users (username,password ,name,createtime,updatetime)VALUES( #{username},#{password},#{name},NOW(),NOW())")
//	@Insert("INSERT INTO users (username,password ,name,createtime,updatetime,roleid)VALUES( #{username},#{password},#{name},NOW(),NOW(),#{roleid})")
	Integer addUser(User user);
	
}
