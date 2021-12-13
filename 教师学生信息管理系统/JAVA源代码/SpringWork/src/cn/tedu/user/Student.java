package cn.tedu.user;

import java.sql.Timestamp;

import com.sun.istack.internal.localization.Localizable;
import com.sun.xml.internal.ws.encoding.soap.SerializationException;

public class Student extends SerializationException{
	private static Localizable msg;
	private String No;
	private String password;
	private String name;
	private String sex;
	private String teNo;
	private Timestamp created;
	private Timestamp updated;
	public Student() {
		super(msg);
		// TODO Auto-generated constructor stub
	}
	public Student(String no, String password, String name, String sex, String teNo, Timestamp created,
			Timestamp updated) {
		super(msg);
		No = no;
		this.password = password;
		this.name = name;
		this.sex = sex;
		this.teNo = teNo;
		this.created = created;
		this.updated = updated;
	}
	public String getNo() {
		return No;
	}
	public void setNo(String no) {
		No = no;
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
	public String getTeNo() {
		return teNo;
	}
	public void setTeNo(String teNo) {
		this.teNo = teNo;
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
		return "Student [No=" + No + ", password=" + password + ", name=" + name + ", sex=" + sex + ", teNo=" + teNo
				+ ", created=" + created + ", updated=" + updated + "]";
	}
	
}
