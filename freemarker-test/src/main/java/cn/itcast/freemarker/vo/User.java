package cn.itcast.freemarker.vo;

import java.util.Date;

/**
 * User
 * @author LEE.SIU.WAH
 * @email lixiaohua7@163.com
 * @date 2017年7月5日 上午10:54:32
 * @version 1.0
 */
public class User {
	public int id;
	private String name;
	private int age;
	private boolean sex;
	private Date birthday;
	public User(){}
	public User(int id, String name, int age, boolean sex, Date birthday) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.birthday = birthday;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public boolean isSex() {
		return sex;
	}
	public void setSex(boolean sex) {
		this.sex = sex;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
}