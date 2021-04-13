package edu.common.util;

public enum C {
	SUCCESS(1),ERROR(500),FAIL(0);
	C(Integer code){
		this.code=code;
	}
	private Integer code;
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public static void main(String[] args) {
		System.out.println(C.SUCCESS.getCode());
	}
}
