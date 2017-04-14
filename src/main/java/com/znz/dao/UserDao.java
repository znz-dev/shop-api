package com.znz.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import com.znz.db.DBAccess;
import com.znz.model.User;

public class UserDao {
	/*
	 * retrieve
	 */
	public User queryUserById(int userId){
		User user = null;
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		//通过sqlSession执行SQL语句
		try{
			sqlSession = dbAccess.getSqlSession();
			user = sqlSession.selectOne("User.find", userId);
		} catch(IOException e){
			e.printStackTrace();
		} finally{
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
		return user;
	}
	
	public List<User> queryUsersByParams() {
		// TODO Auto-generated method stub
		List<User> userList = new ArrayList<User>();
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		//通过sqlSession执行SQL语句
		try{
			sqlSession = dbAccess.getSqlSession();
			userList = sqlSession.selectList("User.userList");
		} catch(IOException e){
			e.printStackTrace();
		} finally{
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
		return userList;
	}
	
	/*
	 * delete
	 */
	public void deleteUserById(int userId){
		User user = queryUserById(userId);
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		//通过sqlSession执行SQL语句
		try{
			sqlSession = dbAccess.getSqlSession();
			sqlSession.delete("User.delete", user);
			sqlSession.commit();
		} catch(IOException e){
			e.printStackTrace();
		} finally{
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
//		return user;
	}
	/*public static void main(String args[]){
		UserDao userDao = new UserDao();
		User user = new User();
		user = userDao.queryUserById(1);
		Logger log = null;
		log.debug("adf");
		log.info(user);
		log.warn(user);
		log.error(user);
	}*/

	public User createUserByParams(User user) {
		// TODO Auto-generated method stub
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		//通过sqlSession执行SQL语句
		try{
			sqlSession = dbAccess.getSqlSession();
			sqlSession.insert("User.insert", user);
			sqlSession.commit();
		} catch(IOException e){
			e.printStackTrace();
		} finally{
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
		return user;
	}

}
