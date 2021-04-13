package edu.common.util;

public class Result {
	private Integer code =1;
	private Boolean success = true;
	private String message ="OK";
	private Object data;

	public void setError(String message){
	    this.success=false;
	    this.code=Code.ERROR;
	    this.message=message;
	}
	
	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}
