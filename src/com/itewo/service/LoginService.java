package com.itewo.service;

import com.itewo.bean.User;
import com.itewo.dao.UserDto;

public class LoginService {
	
	/**
	 * 用户登录： 验证用户的真实性
	 * @param username
	 * @param password
	 * @return
	 */
	 public  boolean countUser(String username,String password){
		 User  user = new User();
		 boolean flag = true;
		 //用户名不能为空
		 if(!username.equals("")&&username!=null){
			 user.setUsername(username);
		 }else{
			 flag = false;
		 }
		 //密码不能为空 (密码在后期应该通过MD5进行加密运算，暂不考虑)
		 if(!password.equals("")&&password!=null){
			 user.setPassword(password);
		 }else{
			 flag = false;
		 }
		 if(flag){
			 UserDto userdto = new UserDto();
			 flag = userdto.countUser(user);
		 }
		 return  flag;
	 }
	 
}
