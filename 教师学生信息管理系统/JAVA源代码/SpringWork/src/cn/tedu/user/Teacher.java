package cn.tedu.user;

import java.sql.Timestamp;

import cn.tedu.base.UserInfo;

public class Teacher extends UserInfo{

	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Teacher(String No, String password, String name, String sex, Timestamp created, Timestamp updated) {
		super(No, password, name, sex, created, updated);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Teacher [No=" + No + ", password=" + password + ", name=" + name + ", sex=" + sex + ", created="
				+ created + ", updated=" + updated + "]";
	}


}
