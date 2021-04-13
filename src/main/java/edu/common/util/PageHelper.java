package edu.common.util;

public class PageHelper {

	//当前页
	private Integer currentPage;
	//每页显示记录数
	private Integer pageSize;
	//总记录数
	private Integer totalCount;
	//总页数
	private Integer totalPage;
	//查询条件对象
	private Object condition;
	//返回数据
	private Object data;
	
	private Integer start;
	private Integer end;
	
	public Integer getStart() {
		return start = (currentPage-1)*pageSize;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Integer getEnd() {
		return end = pageSize;
	}

	public void setEnd(Integer end) {
		this.end = end;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
		setTotalPage((getTotalCount()+getPageSize()-1)/getPageSize());
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	
	public Object getCondition() {
		return condition;
	}
	public void setCondition(Object condition) {
		this.condition = condition;
	}
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	
}
