package cn.tedu.base;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.sun.rowset.CachedRowSetImpl;

import cn.tedu.user.Student;
import cn.tedu.user.Teacher;
/**
 * 定义基础Dao包
 * @author 86173
 *
 */
public class BaseDao {
	
/**
 * 更新数据
 * @throws SQLException 
 */
	public void updateData(String sql,Object...objects) throws SQLException {
		Connection conn = null;
		try {
			conn = JDBCUtil.getConn();
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
			if(objects!=null) {
				for(int i=0;i<objects.length;i++) {
					ps.setObject(i+1, objects[i]);
				}
				ps.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.getClose(conn);
		}
	}
	
	/**
	 * 查询数据
	 * @throws SQLException 
	 */
	public ResultSet findData(String sql,Object...objects) throws SQLException{
		Connection conn = null;
		ResultSet rs = null;
		CachedRowSet crs = null;
		PreparedStatement ps = null;
		try {
			conn = JDBCUtil.getConn();
			ps = (PreparedStatement) conn.prepareStatement(sql);
			if(objects!=null){
				for(int i = 0;i<objects.length;i++){
					ps.setObject(i+1, objects[i]);
				}
				crs = new CachedRowSetImpl();
				rs = ps.executeQuery();
				crs.populate(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}finally{
			JDBCUtil.getClose(conn,rs,ps);
		}
		return crs;
	}
	/**
	 * 用于查找教师信息
	 * @param sql
	 * @param objects
	 * @return
	 * @throws SQLException
	 */
	public ResultSet findTe(String sql,Object...objects) throws SQLException{
		Connection conn = null;
		ResultSet rs = null;
		CachedRowSet crs = null;
		PreparedStatement ps = null;
		try {
			conn = JDBCUtil.getConn();
			ps = (PreparedStatement) conn.prepareStatement(sql);
			if(objects!=null){
				for(int i = 0;i<objects.length;i++){
					ps.setObject(i+1, objects[i]);
				}
				crs = new CachedRowSetImpl();
				rs = ps.executeQuery();
				crs.populate(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}finally{
			JDBCUtil.getClose(conn,rs,ps);
		}
		return crs;
	}
	
	protected Teacher mapper(ResultSet rs) throws SQLException {
		Teacher te = new Teacher();
		te.setName(rs.getString("name"));
		te.setNo(rs.getString("No"));
		te.setPassword(rs.getString("password"));
		te.setSex(rs.getString("sex"));
		te.setCreated(rs.getTimestamp("created"));
		te.setUpdated(rs.getTimestamp("updated"));
		return te;
	}
	
	protected Student Stmapper(ResultSet rs) throws SQLException {
		Student st = new Student();
		st.setName(rs.getString("name"));
		st.setNo(rs.getString("No"));
		st.setPassword(rs.getString("password"));
		st.setSex(rs.getString("sex"));
		st.setTeNo(rs.getString("teNo"));
		st.setCreated(rs.getTimestamp("created"));
		st.setUpdated(rs.getTimestamp("updated"));
		return st;
	}
}
