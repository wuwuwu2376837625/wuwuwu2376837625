package cn.tedu.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.tedu.base.BaseDao;
import cn.tedu.jdbc.ITeacherDao;
import cn.tedu.user.Student;
import cn.tedu.user.Teacher;
@Repository
public class TeacherDao extends BaseDao implements ITeacherDao{
	/**
	 * 教师查找系统
	 * @param id
	 * @param password
	 * @return
	 * @throws SQLException
	 */
	public Teacher FindTeacher(String No) throws SQLException {
		String sql = "SELECT * FROM teacher WHERE No=?";
		ResultSet rs = findTe(sql,No);
		Teacher te = null;
		if(rs.next()) {
			te = mapper(rs);
		}
		return te;
	}

	/**
	 * 更新教师信息
	 */
	public void UpdataTeacherInfo(Teacher te) throws SQLException {
		String sql = "UPDATE teacher SET password=?,name=?,sex=?,updated=NOW() WHERE NO=?";
		updateData(sql,te.getPassword(),te.getName(),te.getSex(),te.getNo());
	}
	/**
	 * 查找账号
	 * @param No
	 * @param password
	 * @return
	 * @throws SQLException
	 */
	public boolean LoginTeacher(String No,String password) throws SQLException {
		String sql = "SELECT * FROM teacher WHERE No=? AND password=?";
		ResultSet rs = findData(sql,No,password);
		if(rs.next()) {
			return true;
		}else {
			return false;
		}
	}
	/**
	 * 注册账号
	 */
	public Boolean InsertTeacher(Teacher te) throws SQLException {
		if(LoginTeacher(te.getNo(),te.getPassword())) {
			return false;
		}else {
			String sql = "INSERT INTO teacher VALUES(?,?,?,?,NOW(),NOW())";
			updateData(sql,te.getNo(),te.getPassword(),te.getName(),te.getSex());
			return true;
		}
	}
/**
 * 
 */
	public ArrayList<Student> FindSt() throws SQLException {
		ArrayList<Student> list = new ArrayList<Student>();
		String sql = "SELECT * FROM student";
		ResultSet rs = findData(sql);
		Student st = null;
		while(rs.next()) {
			st = Stmapper(rs);
			list.add(st);
		}
		return list;
	}
	
}
