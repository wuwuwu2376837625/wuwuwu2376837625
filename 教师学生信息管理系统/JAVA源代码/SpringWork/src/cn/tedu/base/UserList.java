package cn.tedu.base;

import java.util.ArrayList;

import cn.tedu.user.Student;
/**
 * 定义一个父类集合
 * @author 86173
 *
 */
public class UserList {
	public static ArrayList<UserInfo> getList(UserInfo ui){
		ArrayList<UserInfo> list = new ArrayList<UserInfo>();
		list.add(ui);
		return list;
	}
}
