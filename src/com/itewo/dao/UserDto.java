package com.itewo.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.itewo.bean.User;
import com.itewo.db.DBAccess;

public class UserDto {
	
	
	/**
	 *  通过条件查询是否存在当前用户
	 * @param user
	 * @return 如果获取的结果不等于1，则表示系统中不存在或者存在多个相同用户，故返回false,否则返回ture;
	 * 返回true 表示成功
	 */
	public boolean countUser(User user){
		DBAccess dbaccess = new DBAccess();
		SqlSession sqlsession =null;
		int countNum =0;
		try {
			sqlsession = dbaccess.getSqlSession();
			//通过sqsession 执行sql语句;
			countNum = sqlsession.selectOne("User.countUser", user);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(sqlsession != null){
				sqlsession.close();
			}
		}
		//如果获取的结果不等于1，则表示系统中不存在或者存在多个相同用户，故返回false,否则返回ture
		if(countNum!=1 ){
			return false;
		}else{
			return true;
		}
	}
	
	/**
	 * 根据条件查询用户列表
	 * @param user
	 * @return
	 */
   public List<User> queryUser(User user){
	   DBAccess dbaccess = new DBAccess();
		SqlSession sqlsession =null;
		List <User> userList = new ArrayList<User>();
		try {
			sqlsession = dbaccess.getSqlSession();
			//通过sqsession 执行sql语句;
			userList = sqlsession.selectList("User.queryUser",user);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(sqlsession != null){
				sqlsession.close();
			}
		}
	   return userList;
   }
	
   /**
    * 用户注册
    * @param user
    * @return 返回true 表示成功
    */
   public boolean registerUser(User user){
	   DBAccess dbaccess = new DBAccess();
		SqlSession sqlsession =null;
		boolean flag =true;
		int succeedNum = 0;
		try {
			sqlsession = dbaccess.getSqlSession();
			//通过sqsession 执行sql语句;
			 succeedNum = sqlsession.insert("User.registerUser", user);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(sqlsession != null){
				sqlsession.close();
			}
		}
		//注册;注册为单条记录注册，故返回1则为成功，否则为失败；
		if(succeedNum!=1){
			flag =false;
		}
	   return flag;
   }
   
   /**
    *  根据用户ID修改用户信息
    * @param user
    * @return
    */
   public boolean updateUser(User user){
	   DBAccess dbaccess = new DBAccess();
	   SqlSession sqlsession =null;
	   boolean flag = true;
	   int succeedNum = 0;
	   try {
			sqlsession = dbaccess.getSqlSession();
			//通过sqsession 执行sql语句;
			 succeedNum = sqlsession.update("User.updateUser", user);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(sqlsession != null){
				sqlsession.close();
			}
		}
		//修改为单条记录修改，故返回1则为成功，否则为失败；
		if(succeedNum!=1){
			flag =false;
		}
	   return flag;
   }
   
   
}
