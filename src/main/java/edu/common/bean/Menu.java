package edu.common.bean;

import java.util.Map;

public class Menu {

	private Integer id;
	private Integer parentId;
	private String name;
	private String url;
	private Integer type;
	private Map<Integer,Menu> childMenu;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Map<Integer, Menu> getChildMenu() {
		return childMenu;
	}
	public void setChildMenu(Map<Integer, Menu> childMenu) {
		this.childMenu = childMenu;
	}
	
}
