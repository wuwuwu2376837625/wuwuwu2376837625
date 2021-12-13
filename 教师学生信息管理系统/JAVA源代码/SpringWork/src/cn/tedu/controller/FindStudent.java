package cn.tedu.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.tedu.base.PageBean;
import cn.tedu.jdbc.PageDao;
import cn.tedu.jdbc.StudentDao;
import cn.tedu.user.Student;

@Controller
public class FindStudent {
	int currentCount = 4;//模拟每页显示4条
	int currentPage1 = 1;//初始化页数
	String currentPageStr = null;//创建一个String变量接受currentPage数据
	Student st = null;//初始化Student
	ArrayList<Student> studentlist = new ArrayList<>();//学生信息
	ArrayList<Student> list2 = new ArrayList<>();//信息中转站
	PageBean pagebean = null;//初始化pagebean
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
	
	@RequestMapping("/FindSomeSt.do")
	public String FindSomeSt(String currentPage,String No,String name,String sex,HttpServletRequest request) throws SQLException {
		HttpSession sessions = request.getSession();
		sessions.setMaxInactiveInterval(60*60*24);
		list2.clear();
		studentlist.clear();//清空
		int flag = 0;
		if(No.length()==0&&name.length()==0&&sex.equals("null")) {//查询条件为空
			pagebean = new PageBean(1, 1, 1, 1);
			sessions.setAttribute("pagebean", pagebean);
			sessions.setAttribute("studentlist",null);
			return "FindStudent";
		}
		if(No.length()!=0) {//首先判断账号，因为账号唯一
			st = dao.getStNo(No);
			flag = 1;
			if(name.length()!=0&&st.getName().equals(name)) {//姓名符合条件
				flag = 1;
				if(sex.equals("null")||st.getSex().equals(sex)){//性别符合条件或为空 输出
					flag = 1;
				}else{//性别不符合条件且不为空
					flag = 0;
				}
			}else if(name.length()!=0) {//有姓名但不符合条件
				flag = 0;
			}else if(name.length()==0) {//没有姓名
				if(sex.equals("null")) {
					flag = 1;
				}else{
					if(st.getSex().equals(sex)) {
						flag = 1;
					}else {
						flag = 0;
					}
					
				}
			}
		}else{//账号为空
			if(name.length()!=0) {//判断姓名 姓名重复率也比较低
				list2 = dao.getName(name);
				if(sex.equals("null")){//性别为空时，将list2数据复制到studentlist
					for(Student l:list2) {
						studentlist.add(l);
						}
				}else {//性别不为空时，将list2中符合条件的筛选并复制到studentlist中
					for(Student l:list2) {
						if(l.getSex().equals(sex)) {
							studentlist.add(l);
						}
					}
				}
			}else {//未选择学号和姓名时，查询性别
				studentlist = dao.getSex(sex);
			}
		}
		if(No.length()!=0) {
			if(flag==1) {
				studentlist.add(st);
				pagebean = new PageBean(1, 1, 1, 1);
				sessions.setAttribute("pagebean", pagebean);
				sessions.setAttribute("studentlist",studentlist);
				return "FindStudent";
			}else if(flag == 0) {
				studentlist.add(null);
				pagebean = new PageBean(1, 1, 1, 1);
				sessions.setAttribute("pagebean", pagebean);
				sessions.setAttribute("studentlist",null);
				return "FindStudent";
			}
		}

		setlist(studentlist);
		currentPageStr = currentPage;
		if(currentPageStr==null){//模拟当前页为1
			currentPageStr = "1";
		}
		currentPage1 = Integer.parseInt(currentPageStr);
		pagebean = pdao.FindPage(studentlist, currentPage1, currentCount);
		list2.clear();
		int i = 1;
		for(Student l:studentlist) {
			if(i >=1&&i<=currentCount) {
				list2.add(l);
			}
			i++;
		}
		sessions.setAttribute("studentlist",list2);
		sessions.setAttribute("pagebean", pagebean);
		return "FindStudent";
	}
	@RequestMapping("/FindPaSt.do")
	public String FindPaSt(String currentPage,HttpServletRequest request) throws SQLException {
		HttpSession sessions = request.getSession();
		sessions.setMaxInactiveInterval(60*60*24);
		currentPageStr = currentPage;
		currentPage1 = Integer.parseInt(currentPageStr);
		pagebean = pdao.FindPage(studentlist, currentPage1, currentCount);
		int initnum;
		if(currentPage1==1) {
			initnum = currentPage1;
		}else {
			initnum = (currentPage1-1)*currentCount+1;
		}
		int i = 1;
		list2.clear();
		for(Student l:studentlist) {
			if(i >= initnum&&i<initnum+currentCount) {
				list2.add(l);
			}
			i++;
		}
		sessions.setAttribute("studentlist",list2);
		sessions.setAttribute("pagebean", pagebean);
		return "FindStudent";
	}
	
	public void setlist(ArrayList<Student> studentlist){
		this.studentlist = studentlist;
	}
	public ArrayList<Student> getlist(){
		return studentlist;
	}
}
