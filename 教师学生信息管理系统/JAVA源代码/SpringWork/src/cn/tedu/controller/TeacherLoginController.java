package cn.tedu.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.tedu.base.UserInfo;
import cn.tedu.base.UserList;
import cn.tedu.jdbc.ITeacherDao;
import cn.tedu.user.Teacher;
/**
 * 登录
 * @author 86173
 *
 */
@Controller
public class TeacherLoginController {
	@Resource
	ITeacherDao dao;
	public void setTeacherDao(ITeacherDao dao) {
		this.dao = dao;
	}
	/**
	 * 转到登陆页面
	 * @return
	 */
	@RequestMapping("/toTeLogin.do")
	public String toTeLogin() {
		return "TeLogin";
	}
	/**
	 * 登录逻辑代码
	 * @param No
	 * @param password
	 * @param isAuto
	 * @param response
	 * @param request
	 * @return
	 * @throws SQLException
	 * @throws IOException 
	 */
	@RequestMapping("/TeLogin.do")
	public String TeLogin(String No,String password,String isAuto,HttpServletResponse response,HttpServletRequest request) throws SQLException, IOException {
		String msg = null;
		if(No.length()==0|password.length()==0) {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.print("<script>alert('账号或密码不得为空!!'); window.location='TeLogin.jsp' </script>");
			out.flush();
			out.close();
		}
		boolean islogin = dao.LoginTeacher(No, password);
		if(islogin) {
			//判断是否需要保存密码 
			if(isAuto!=null) {//需要保存密码 实用cookie
				//通过cookie 保存登陆成功的账号和密码
				Cookie ucookie = new Cookie("No",No);
				ucookie.setMaxAge(60*60*24*30);
				ucookie.setPath("/");
				response.addCookie(ucookie);
				Cookie pcookie = new Cookie("pw",password);
				pcookie.setMaxAge(60*60*24*30);
				pcookie.setPath(password);
				response.addCookie(pcookie);
			}
			else {//不需要保存密码 用null赋值给cookie
				Cookie ucookie = new Cookie("No",null);
				ucookie.setMaxAge(60*60*24*30);
				ucookie.setPath("/");
				response.addCookie(ucookie);
				Cookie pcookie = new Cookie("pw",null);
				pcookie.setMaxAge(60*60*24*30);
				pcookie.setPath(password);
				response.addCookie(pcookie);
			}
			HttpSession sessions = request.getSession();
			sessions.setMaxInactiveInterval(60*60*24);
			sessions.setAttribute("No", No);//获取session中的NO
			return "main";//重定向
		}
		else {
			msg = "登陆失败，请输入正确的账号密码！！正在重新返回登陆页面...";
			request.setAttribute("msg", msg);
			return "error";//登陆失败
		}
	}
	
}
