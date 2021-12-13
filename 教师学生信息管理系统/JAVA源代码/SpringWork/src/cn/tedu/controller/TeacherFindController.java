package cn.tedu.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.tedu.base.UserInfo;
import cn.tedu.base.UserList;
import cn.tedu.jdbc.ITeacherDao;
import cn.tedu.user.Teacher;

@Controller
public class TeacherFindController {
	@Resource
	ITeacherDao dao;
	public void setTeacherDao(ITeacherDao dao) {
		this.dao = dao;
	}
	@RequestMapping("/ToMain.do")
	public String ToMain() {
		return "main";
	}
	@RequestMapping("/TeFind.do")
	public String TeFind(String No,HttpServletRequest request) throws SQLException {
		Teacher te = dao.FindTeacher(No);
		ArrayList<UserInfo> telist = UserList.getList(te);;//定理一个集合存储Teacher
		HttpSession sessions = request.getSession();
		sessions.setMaxInactiveInterval(60*60*24);
		sessions.setAttribute("telist", telist);//获取session中的Teacher集合
		return "TeFind";
	}
}
