package cn.tedu.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.tedu.base.UserInfo;
import cn.tedu.base.UserList;
import cn.tedu.jdbc.ITeacherDao;
import cn.tedu.user.Teacher;

@Controller
public class TeacherUpdataController {
	@Resource
	ITeacherDao dao;
	public void setTeacherDao(ITeacherDao dao) {
		this.dao = dao;
	}
	/**
	 * 转到更新数据页面
	 * @return
	 */
	@RequestMapping("/toTeUpdata.do")
	public String ToUpdata() {
		return "TeUpdata";
	}
	/**
	 * 修改信息逻辑代码
	 * @param name
	 * @param No
	 * @param password
	 * @param age
	 * @param sex
	 * @param phone
	 * @param faculty
	 * @return
	 * @throws SQLException
	 */
	@RequestMapping("/TeUpdata.do")
	public String TeUpdata(String name,String No,String password,String sex,HttpServletRequest request,HttpServletResponse response) throws SQLException {
		Teacher te = new Teacher(No,password,name,sex,null,null);
		dao.UpdataTeacherInfo(te);
		Teacher te1 = dao.FindTeacher(No);
		ArrayList<UserInfo> telist = UserList.getList(te1);;//定理一个集合存储Teacher
		HttpSession sessions = request.getSession();
		sessions.setAttribute("telist", telist);//获取session中的Teacher集合
		return "TeFind";
	}
}
