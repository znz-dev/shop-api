package com.znz.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.znz.model.*;

@Service
public interface UserService {

	
	// TODO
	//User createUserByParams();
	// TODO 
	User getUserById(int userId);
	// TODO
	//User updateUserByParams();
	
	void destroyUserById(int userId);
	// TODO
	//User loginUserByParams();

	List<User> getUsersByParams();

	User createUserByParams(User user);

	User updateUserByParams(User user);
}
