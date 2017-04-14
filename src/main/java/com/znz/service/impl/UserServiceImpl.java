package com.znz.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import com.znz.service.*;
import com.znz.model.*;
import com.znz.dao.*;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	public User getUserById(int userId) {
		User user = new User();
		UserDao userDao = new UserDao();
		user = userDao.queryUserById(userId);
		return user;
	}
	
	public void destroyUserById(int userId) {
		UserDao userDao = new UserDao();
		userDao.deleteUserById(userId);
		
	}

	public List<User> getUsersByParams() {
		// TODO Auto-generated method stub
		UserDao userDao = new UserDao();
		List<User> userList = new ArrayList<User>();
		userList = userDao.queryUsersByParams();
		return userList;
	}

	public User createUserByParams(User user) {
		UserDao userDao = new UserDao();
		user = userDao.createUserByParams(user);
		return user;
	}

	public User updateUserByParams(User user) {
		UserDao userDao = new UserDao();
		user = userDao.updateUserByParams(user);
		return user;
	}
}
