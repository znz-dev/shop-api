package com.znz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.znz.model.*;
import com.znz.service.*;

@CrossOrigin
@Controller
@RequestMapping("/user")
public class UserController {
	
	private UserService userService;
	
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	/*
	 * 创建 (create)
	 */
	
	@RequestMapping(value="" ,method=RequestMethod.POST)
	public @ResponseBody User createUsersInJson(@ModelAttribute User user){
		System.out.println("this is create");
		return  userService.createUserByParams(user);
	}
	
	/*
	 * 获取全部用户 (all)
	 */
	
	@RequestMapping(value="" ,method=RequestMethod.GET)
	public @ResponseBody List<User> getUsersInJson(){
		System.out.println("this is all");
		return  userService.getUsersByParams();
	}
	
	/*
	 * 通过用户id获取用户 (show)
	 */
	
	@RequestMapping(value="/{userId}",method=RequestMethod.GET)
	public @ResponseBody User getUserInJson(@PathVariable Integer userId){
		System.out.println("this is show");
		return  userService.getUserById(userId);
	}
	

	/*
	 * 通过用户id更新用户信息 (update)
	 */
	
	@RequestMapping(value="/{userId}",method=RequestMethod.PUT)
	public @ResponseBody User updateUserInJson(@ModelAttribute User user, @PathVariable Integer userId){
		System.out.println("this is update");
		user.setId(userId);
		return  userService.updateUserByParams(user);
	}
	
	/*
	 * 通过用户id删除用户(delete)
	 */
	
	@RequestMapping(value="/{userId}",method=RequestMethod.DELETE)
	public @ResponseBody void destroyUserById(@PathVariable Integer userId){
		System.out.println("this is delete");
		userService.destroyUserById(userId);
	}
	
	/*
	 * TODO 用户登录
	 */
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public @ResponseBody User loginUserInJson(@PathVariable Integer userId){
		return  userService.getUserById(userId);
	}
	
	@RequestMapping("/mvc")
	public String helloMvc() {
		
	//WEB-INF/jsps/home.jsp
		return "home";
	}
	
	/*@RequestMapping(value="/register",method=RequestMethod.POST)
	public @ResponseBody User createUserInJson(@PathVariable Integer userId){
		
	}*/
}
