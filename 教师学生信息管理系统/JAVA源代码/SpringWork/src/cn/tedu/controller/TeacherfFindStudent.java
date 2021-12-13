package cn.tedu.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.tedu.base.PageBean;
import cn.tedu.base.UserList;
import cn.tedu.jdbc.ITeacherDao;
import cn.tedu.jdbc.PageDao;
import cn.tedu.user.Student;

@Controller
public class TeacherfFindStudent {
	@Resource
	ITeacherDao dao;
	public void setTeacherDao(ITeacherDao dao) {
		this.dao = dao;
	}
	@Resource
	PageDao pdao;
	public void setPageDao(PageDao pdao) {
		this.pdao = pdao;
	}
	
	@RequestMapping("/FindAllSt.do")
	public String FindSt(String currentPage,HttpServletRequest request) throws SQLException {;
		String currentPageStr = currentPage;
		HttpSession sessions = request.getSession();
		if(currentPageStr==null){//模拟当前页为1
			currentPageStr = "1";
		}
		int currentPage1 = Integer.parseInt(currentPageStr);
		int currentCount = 4;//模拟每页显示4条
		int index = (currentPage1-1)*currentCount;
		ArrayList<Student> stalllist = dao.FindSt();
		PageBean pagebean = pdao.FindPage(stalllist, currentPage1, currentCount);   
		ArrayList<Student> stpagelist = pdao.FindStPage(index, currentCount);
		sessions.setMaxInactiveInterval(60*60*24);
		sessions.setAttribute("pagebean",pagebean);
		sessions.setAttribute("stpagelist",stpagelist);
		sessions.setAttribute("stlist",stalllist);
		return "FindAllSt";
	}
}
