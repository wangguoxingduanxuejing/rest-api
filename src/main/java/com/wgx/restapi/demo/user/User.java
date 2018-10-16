package com.wgx.restapi.demo.user;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class User {
	private int id;
	private String name;
	private int age;
	private String sex;
	private Date birthday;
	private MultipartFile headPhoto;
	private MultipartFile idPhoto;
	
	public User() {
		super();
		
	}
	
	public User(int id, String name, int age, String sex, Date birthday) {
		super();
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

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	

	public MultipartFile getHeadPhoto() {
		return headPhoto;
	}

	public void setHeadPhoto(MultipartFile headPhoto) {
		this.headPhoto = headPhoto;
	}

	public MultipartFile getIdPhoto() {
		return idPhoto;
	}

	public void setIdPhoto(MultipartFile idPhoto) {
		this.idPhoto = idPhoto;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", age=" + age + ", sex=" + sex + ", birthday=" + birthday + "]";
	}
	
	
	
	
	
}
