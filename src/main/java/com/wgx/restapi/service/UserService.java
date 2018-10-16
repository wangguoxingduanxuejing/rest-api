package com.wgx.restapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wgx.restapi.dao.UserDao;
import com.wgx.restapi.pojo.User;

@Service
public class UserService {

	@Autowired UserDao userdao;
	
	public List<User> getAll(){
		return userdao.getAll();
	} 
	
	public int deleteUser(User user){
		return userdao.deleteUser(user);
	}
	
	public int addUser(User user){
		return userdao.addUser(user);
	}
	
	public int updataUser(User user){
		return userdao.updateUser(user);
	}
}
