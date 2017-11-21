package com.lushunde.springboot.junit.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.lushunde.springboot.junit.model.User;
import com.lushunde.springboot.junit.service.UserService;

@RestController
@RequestMapping("user")
public class UserController {
	
	@Autowired 
	private UserService userService;
	
	@RequestMapping(value="getUser",method=RequestMethod.GET)
	public User getUserById(HttpServletRequest request, Integer id){
		User user = this.userService.getUserById(id);
		return user;
	}
	
	@RequestMapping(value="findByPage",method=RequestMethod.POST)
	public PageInfo<User> findByPage(HttpServletRequest request,Integer pageNo,Integer pageSize){
		PageInfo<User> list  = ((Page<User>)this.userService.findByPage(pageNo,pageSize)).toPageInfo();
		return list;
	}
	
	@RequestMapping(value="saveUser" ,method=RequestMethod.POST)
	public void saveUser(HttpServletRequest request,@RequestBody User user){
		System.out.println(request.getHeader("SESSIONNO"));
		this.userService.saveUser(user);
	}
	
	@RequestMapping(value="updateUser" ,method=RequestMethod.POST)
	public void updateUser(HttpServletRequest request,@RequestBody User user){
		this.userService.updateUser(user);
	}
	
	@RequestMapping(value="deleteUser",method=RequestMethod.GET )
	public Integer deleteUser(Long id){
		System.out.println(id);
		return this.userService.deleteUser(id);
	}
	
	
}
