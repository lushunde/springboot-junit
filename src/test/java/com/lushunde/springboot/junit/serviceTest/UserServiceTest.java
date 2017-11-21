package com.lushunde.springboot.junit.serviceTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.lushunde.springboot.junit.StartBootstarp;
import com.lushunde.springboot.junit.model.User;
import com.lushunde.springboot.junit.service.UserService;

import junit.framework.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=StartBootstarp.class)
@WebAppConfiguration
public class UserServiceTest {

	@Autowired
	private UserService userService;
	
	
	/**
	 * 测试 接口
	 */
	@Test
	public void getUserByIdTest(){
		User user = this.userService.getUserById(2);
		System.out.println(user.toString());
		System.out.println(user.getUsername().equals("lisi"));
		
	}
	
}
