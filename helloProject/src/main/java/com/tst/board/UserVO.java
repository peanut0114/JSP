package com.tst.board;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserVO {
	private String id;
	private String passwd;
	private String name;
	@Override
	public String toString() {
		return "UserVO [id=" + id + ", passwd=" + passwd + ", name=" + name + "]";
	}
	
}
