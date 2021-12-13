package cn.tedu.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import cn.tedu.base.BaseDao;
import cn.tedu.base.PageBean;
import cn.tedu.user.Student;

@Repository
public class PageDao extends BaseDao {    
	
	public PageBean FindPage(ArrayList<Student> stlist,int currentPage,int currentCount) throws SQLException {
		PageBean pagebean = new PageBean();
        int totalCount = stlist.size();//总条数
        int totalPage;
        if(totalCount%currentCount==0) {//总页数
        	totalPage = totalCount/currentCount;
        }else {
        	totalPage = totalCount/currentCount+1;
        }
        int index = (currentPage-1)*currentCount;//从第几条数据开始
        pagebean.setCurrentPage(currentPage);//当前页    
        pagebean.setCurrentCount(currentCount);//当前显示条数
        pagebean.setTotalPage(totalPage);
        pagebean.setTotalCount(stlist.size());
		return pagebean;
	}
	
    /**
     * 获取分页的商品数据
     * @param index
     * @param currentCount
     * @return
     * @throws SQLException
     */
    public ArrayList<Student> FindStPage(int index,int currentCount) throws SQLException {
        String sql = "SELECT * FROM Student LIMIT ?,?";
        ArrayList<Student> stpage= new ArrayList<>();
        ResultSet rs = findData(sql, index,currentCount);
		Student st = null;
		while(rs.next()) {
			st = Stmapper(rs);
			stpage.add(st);
		}
        return stpage;
    }
	
}
