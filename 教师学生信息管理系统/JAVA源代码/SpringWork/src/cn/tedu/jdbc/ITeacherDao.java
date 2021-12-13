package cn.tedu.jdbc;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import cn.tedu.user.Student;
import cn.tedu.user.Teacher;

/**
 * 定义一个Teacher接口
 * @author 86173
 *
 */
public interface ITeacherDao {
	public void UpdataTeacherInfo(Teacher te) throws SQLException;
	public Teacher FindTeacher(String No) throws SQLException;
	public Boolean InsertTeacher(Teacher te) throws SQLException;
	public boolean LoginTeacher(String No,String password) throws SQLException;
	public ArrayList<Student> FindSt() throws SQLException;
}
