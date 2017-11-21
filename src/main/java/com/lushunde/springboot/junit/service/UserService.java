package com.lushunde.springboot.junit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.lushunde.springboot.junit.mapper.UserMapper;
import com.lushunde.springboot.junit.model.User;

@Service
public class UserService {
	
	@Autowired
	private UserMapper mapper;

	public User getUserById(Integer id) {
		return this.mapper.getUserById(id);
	}

	
	public List<User> findByPage(Integer pageNo,Integer pageSize ){
		PageHelper.startPage(pageNo, pageSize);
		return this.mapper.findByPage();
	}


	public void saveUser(User user) {
		this.mapper.insertUser(user);
	}


	public Integer deleteUser(Long id) {
		
		return this.mapper.deleteUser(id);
	}


	public void updateUser(User user) {
		this.mapper.updateUser(user);
		
	}
	
	
	
	
//	private Map<Integer, User> users = new HashMap<Integer, User>();
//	
//	@PostConstruct
//	private void init (){
//		users.put(1 , new User(1,"zhangsan", 18));
//		users.put(2	, new User(2,"lisi",22));
//		users.put(3	, new User(3,"wangwu",29));
//		users.put(4	, new User(4,"zhaoliu",15));
//	}
//	
//	public User getUserById(Integer id) {
//		
//		return users.get(id);
//	}
//
//	public Integer saveUser(User user) {
//		int size = users.size();
//		user.setId(size);
//		users.put(users.size(), user);
//		
//		return size;
//	}
//	
	
	
}
