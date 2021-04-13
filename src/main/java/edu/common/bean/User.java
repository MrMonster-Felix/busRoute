package edu.common.bean;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class User {

	private Integer id;
	private String username;
	private String password;
	private String name;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
    @DateTimeFormat(pattern="yyyy-MM-dd")//set
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")//get
	private Date createtime;
    @DateTimeFormat(pattern="yyyy-MM-dd")//set
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")//get
	private Date updatetime;
	private Integer roleid;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public Date getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}
	public Integer getRoleid() {
		return roleid;
	}
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}
	
}
