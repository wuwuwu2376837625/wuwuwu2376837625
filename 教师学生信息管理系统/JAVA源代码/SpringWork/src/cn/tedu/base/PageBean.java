package cn.tedu.base;

public class PageBean {
    private int currentPage;	//当前页
    private int currentCount;    //当前显示条数
    private int totalPage;    //总页数
    private int totalCount;    //总条数

    public PageBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PageBean(int currentPage, int currentCount, int totalPage, int totalCount) {
		super();
		this.currentPage = currentPage;
		this.currentCount = currentCount;
		this.totalPage = totalPage;
		this.totalCount = totalCount;
	}
	public int getCurrentPage() {
        return currentPage;
    }
    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }
    public int getCurrentCount() {
        return currentCount;
    }
    public void setCurrentCount(int currentCount) {
        this.currentCount = currentCount;
    }
    public int getTotalPage() {
        return totalPage;
    }
    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }
    public int getTotalCount() {
        return totalCount;
    }
    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

	@Override
	public String toString() {
		return "PageBean [currentPage=" + currentPage + ", currentCount=" + currentCount + ", totalPage=" + totalPage
				+ ", totalCount=" + totalCount + "]";
	}
}
