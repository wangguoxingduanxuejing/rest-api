package com.wgx.restapi.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.wgx.restapi.pojo.User;

public interface UserDao {
	
	@Select("select * from user")
	public List<User> getAll();
	
	@Delete("delete from user where id =#{id}")
	public int deleteUser(User user);
	
	@Insert("insert into user(uname,age) values (#{uname},#{age})")
	public int addUser(User user);
	
	@Insert("update user set uname = #{uname},age = #{age} where id = #{id}")
	public int updateUser(User user);
}
