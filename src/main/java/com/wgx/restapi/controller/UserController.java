package com.wgx.restapi.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wgx.restapi.demo.DemoApi;
import com.wgx.restapi.pojo.User;
import com.wgx.restapi.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	private static final Log log = LogFactory.getLog(DemoApi.class);
	@Autowired UserService userService;
	
	@GetMapping
	public List<User> getAll(){
		return userService.getAll();
	}
	
	@DeleteMapping("/{id}")
	public int deleteUser(@PathVariable int id){
		System.out.println("=================================="+id);
		log.info("==================================="+id);
		User user = new User();
		user.setId(id);
		return userService.deleteUser(user);
	}
	
	@PostMapping
	public int addUser(@RequestBody User user){
		return userService.addUser(user);
	}
	
	@PutMapping
	public int updateUser(@RequestBody User user){
		return userService.updataUser(user);
	}
	
}
