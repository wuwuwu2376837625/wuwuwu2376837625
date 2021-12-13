package cn.tedu.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.tedu.base.PageBean;
import cn.tedu.jdbc.PageDao;
import cn.tedu.jdbc.StudentDao;
import cn.tedu.user.Student;

@Controller
public class StudentUpdataController {
	@Resource
	StudentDao dao;
	public void setStudentDao(StudentDao dao) {
		this.dao = dao;
	}
	@Resource
	PageDao pdao;
	public void setPageDao(PageDao pdao) {
		this.pdao = pdao;
	}
	/**
	 * 返回到更新学生信息页面
	 * @param StNo
	 * @param request
	 * @return
	 */
	@RequestMapping("/ToStUpdata.do")
	public String ToUpdata(String StNo,HttpServletRequest request) {
		HttpSession sessions = request.getSession();
		sessions.setMaxInactiveInterval(60*60*24);
		sessions.setAttribute("StNo", StNo);//获取session中的NO
		return "StUpdata";
	}
	/**
	 * 学生信息更新
	 * @param name
	 * @param No
	 * @param password
	 * @param sex
	 * @param teNo
	 * @param request
	 * @param response
	 * @return
	 * @throws SQLException
	 */
	@RequestMapping("/StUpdata.do")
	public String StUpdata(String name,String No,String sex,String teNo,HttpServletRequest request) throws SQLException {
		Student st = new Student(No,"123456",name,sex,teNo,null, null);
		dao.StUpdata(st);
		HttpSession sessions = request.getSession();
		ArrayList<Student> stalllist = dao.FindSt(null);
		PageBean pagebean = pdao.FindPage(stalllist, 1, 4);   
		ArrayList<Student> stpagelist = pdao.FindStPage(0, 4);
		sessions.setAttribute("pagebean",pagebean);
		sessions.setAttribute("stpagelist",stpagelist);
		sessions.setAttribute("stlist",stalllist);
		return "FindAllSt";
	}
	/**
	 * 删除
	 * @param No
	 * @param request
	 * @return
	 * @throws SQLException 
	 * @throws IOException 
	 */
	@RequestMapping("/StDelete.do")
	public void StDelete(String StNo,HttpServletRequest request,HttpServletResponse response) throws SQLException, IOException {
		dao.StDelete(StNo);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<script>alert('删除成功！！'); window.location='FindAllSt.do' </script>");
		out.flush();
		out.close();
	}
	@RequestMapping("/ToStInsert.do")
	public String ToStInset() {
		return "StInsert";
	}
	@RequestMapping("/StInsert.do")
	public void StInsert(String No, String password, String name, String sex, String teNo,HttpServletResponse response) throws SQLException, IOException {
		Student st = new Student(No,password,name,sex,teNo,null,null);
		boolean isInsert = dao.StInsert(st);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		if(isInsert) {
			out.print("<script>alert('添加成功！！正在返回学生信息页面'); window.location='FindAllSt.do' </script>");
			out.flush();
			out.close();
		}else {
			out.print("<script>alert('添加失败，账号已存在！！请重新输入'); window.location='ToStInsert.do' </script>");
			out.flush();
			out.close();
		}
	}
}
