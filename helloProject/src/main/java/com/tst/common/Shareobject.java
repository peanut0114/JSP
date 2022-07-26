package com.tst.common;
/*
 * 정수, 문자형 값 : 공유
 * 서블릿 두개를 만들어서 공유
 * 
 */
public class Shareobject {

	private int count;
	private String str;
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getStr() {
		return str;
	}
	public void setStr(String str) {
		this.str = str;
	}
	
	
}
