package cn.tedu.base;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
/**
 * 链接数据库
 * @author 86173
 *
 */
public class JDBCUtil {
	private static String url = "jdbc:mysql://localhost:3315/blog?useUnicode=true&characterEncoding=UTF-8";
	private static String dbun = "root";
	private static String dbpw = "123456";
	private static String classname = "com.mysql.jdbc.Driver";
	static {
		try {
			Class.forName(classname);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 创建链接
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConn() throws SQLException {
		Connection conn = (Connection) DriverManager.getConnection(url,dbun,dbpw);
		return conn;
	}
	
	/**
	 * 关闭连接
	 * @param conn
	 * @throws SQLException
	 */
	public static void getClose(Connection conn) throws SQLException {
		if(conn!=null) {
			conn.close();
		}
	}
	public static void getClose(Connection conn,ResultSet rs,PreparedStatement ps) throws SQLException {
		if(conn!=null) {
			conn.close();
		}
		if(rs!=null) {
			conn.close();
		}
		if(ps!=null) {
			conn.close();
		}
	}
}
