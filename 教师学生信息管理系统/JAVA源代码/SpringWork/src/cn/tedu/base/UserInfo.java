package cn.tedu.base;

import java.sql.Timestamp;
/**
 * 定义一个父类的对象
 * @author 86173
 *
 */
public class UserInfo {
	protected String No;//工号（也是登录账号）
	protected String password;//密码
	protected String name;//姓名
	protected String sex;//性别 true男 false女
	protected Timestamp created;//创建时间
	protected Timestamp updated;//最近访问时间
	
	public UserInfo() {
		super();
	}
	public UserInfo(String No, String password, String name, String sex, Timestamp created,Timestamp updated) {
		super();
		this.No = No;
		this.password = password;
		this.name = name;
		this.sex = sex;
		this.created = created;
		this.updated = updated;
	}
	public String getNo() {
		return No;
	}
	public void setNo(String No) {
		this.No = No;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Timestamp getCreated() {
		return created;
	}
	public void setCreated(Timestamp created) {
		this.created = created;
	}
	public Timestamp getUpdated() {
		return updated;
	}
	public void setUpdated(Timestamp updated) {
		this.updated = updated;
	}
	@Override
	public String toString() {
		return "UserInfo [No=" + No + ", password=" + password + ", name=" + name + ", sex=" + sex
				+ ", created=" + created + ", updated=" + updated + "]";
	}
}
