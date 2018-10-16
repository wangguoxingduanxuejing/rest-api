package com.wgx.restapi.pojo;

public class User {

	private int id;
	private String uname;
	private int age;
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}


	public User(int id, String uname, int age) {
		super();
		this.id = id;
		this.uname = uname;
		this.age = age;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getUname() {
		return uname;
	}


	public void setUname(String uname) {
		this.uname = uname;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", uname=" + uname + ", age=" + age + "]";
	}
	
	
	
	
}
