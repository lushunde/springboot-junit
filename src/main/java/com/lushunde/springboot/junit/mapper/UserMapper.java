package com.lushunde.springboot.junit.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.lushunde.springboot.junit.model.User;

@Mapper
public interface UserMapper {

	public User getUserById(Integer id);

	public List<User> findByPage();
	
	public void insertUser(User user);

	public Integer deleteUser(Long id);

	public Integer updateUser(User user);

}
