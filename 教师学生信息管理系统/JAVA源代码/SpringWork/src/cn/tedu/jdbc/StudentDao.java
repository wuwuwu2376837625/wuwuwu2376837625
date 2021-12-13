package cn.tedu.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import cn.tedu.base.BaseDao;
import cn.tedu.user.Student;
/**
 * 学生类的dao包
 * @author 86173
 *
 */
@Repository
public class StudentDao extends BaseDao{
/**
 * 查找所有学生信息
 * @param No
 * @return
 * @throws SQLException
 */
	public ArrayList<Student> FindSt(String No) throws SQLException {
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
	/**
	 * 通过No查找学生信息
	 * @param No
	 * @return
	 * @throws SQLException
	 */
	public Student getStNo(String No) throws SQLException{
		String sql = "SELECT * FROM student WHERE No=?";
		ResultSet rs = findData(sql, No);
		Student st = null;
		if(rs.next()) {
			st = Stmapper(rs);
		}
		return st;
	}
	/**
	 * 通过name查找学生信息
	 * @param name
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<Student> getName(String name) throws SQLException{
		ArrayList<Student> stlist = new ArrayList<>();
		String sql = "SELECT * FROM student WHERE name=?";
		ResultSet rs = findData(sql, name);
		Student st = null;
		while(rs.next()) {
			st = Stmapper(rs);
			stlist.add(st);
		}
		return stlist;
	}
	/**
	 * 通过sex查找学生信息
	 * @param sex
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<Student> getSex(String sex) throws SQLException{
		ArrayList<Student> stlist = new ArrayList<>();
		Student st = null;
		String sql = "SELECT * FROM student WHERE sex=?";
		ResultSet rs = findData(sql, sex);
		while(rs.next()) {
			st = Stmapper(rs);
			stlist.add(st);
		}
		return stlist;
	}
	/**
	 * 学生信息更新
	 * @param st
	 * @throws SQLException
	 */
	public void StUpdata(Student st) throws SQLException {
		String sql = "UPDATE student SET password=?,name=?,sex=?,teNo=?,updated=NOW() WHERE No=?";
		updateData(sql, st.getPassword(),st.getName(),st.getSex(),st.getTeNo(),st.getNo());
	}
	/**
	 * 学生信息删除
	 * @param No
	 * @throws SQLException
	 */
	public void StDelete(String No) throws SQLException {
		String sql = "DELETE FROM student WHERE No=?";
		updateData(sql, No);
	}
	/**
	 * 添加学生信息并返回添加的结果true or false
	 * @param st
	 * @return
	 * @throws SQLException
	 */
	public boolean StInsert(Student st) throws SQLException {
		Student st1 = getStNo(st.getNo());
		if(st1!=null) {
			return false;
		}
		String sql = "INSERT INTO student VALUES(?,?,?,?,?,NOW(),NOW())";
		updateData(sql,st.getNo(),st.getPassword(),st.getName(),st.getSex(),st.getTeNo());
		return true;
	}
}
