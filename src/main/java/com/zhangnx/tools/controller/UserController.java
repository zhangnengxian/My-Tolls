package com.zhangnx.tools.controller;

import java.util.List;

import com.zhangnx.tools.dao.UserDao;
import com.zhangnx.tools.entity.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	private static Logger logger =Logger.getLogger(UserController.class);
	@Autowired
	private UserDao userDao;
	

	@GetMapping("/findAllJpaUser")
	public List<User> findAllJpaUser(){
		logger.info("find all user by JPA.");
		return userDao.findAllUser(); 
		
	}
	
	@GetMapping("/findJpaUserById/{id}")
	public User findJpaUserById(@PathVariable("id") int id) {
		logger.info("find specific user by JPA.");
		return userDao.findUserById(id); 
	}
	
	@GetMapping("/findJpaUserByUserName/{userName}")
	public User findJpaUserByUserName(@PathVariable("userName") String userName) {
		logger.info("find specific user by JPA.");
		return userDao.findUserByUserName(userName); 
	}
	
	@GetMapping("/updateUserById/{id}/{userName}")
	public String updateUserById(@PathVariable("id") int id,@PathVariable("userName") String userName) {
		logger.info("update specific user by JPA.");
		userDao.updateUserById(id, userName);
		return "success";
	}
	
	@GetMapping("/findJpaUserBySubId/{subId}")
	public User findJpaUserBySubId(@PathVariable("subId") int subId) {
		logger.info("find sub user by JPA.");
		return userDao.findUserBySubId(subId); 
	}
}
