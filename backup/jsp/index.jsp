<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%  String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>  

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>欢迎登录后台管理系统</title>
<link 	href="<%= basePath %>resources/css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="<%= basePath %>resources/js/jquery.js"></script>
<script type="text/javascript" src="<%= basePath %>resources/js/cloud.js" ></script>

<script language="javascript">
	$(function(){
    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
	$(window).resize(function(){  
    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
    }) 
    
    //点击登录，实现ajax请求
    $("#loginButton").click(function(){
    	
	   	 var dataString ='username='+$("input[name='username']") .val()+'&password='+$("input[name='password']") .val(); 
	   	 console.log("<%=basePath %>");
	   	 $.ajax({  
	            url:"<%=basePath %>Login.do",
	            type:'post',  
	            data:dataString,  
	            success:function(data){  
	               if(!data){
	            	   alert("用户名或者密码错误!");
	               }else{
	            	   location.href = "<%=basePath %>WEB-INF/jsp/main.jsp";
	            	   //location.href实现客户端页面的跳转  web-inf 下的资源必须通过servlet 进行访问  故不能直接跳转
	               }
	               
	               
	            }  
	        });  
		  });
	//登录请求结束
	
	});  
	
	
	
</script> 

</head>

<body style="background-color:#1c77ac; background-image:url(<%= basePath %>resources/images/light.png); 
background-repeat:no-repeat; background-position:center top; overflow:hidden;">



    <div id="mainBody">
      <div id="cloud1" class="cloud"></div>
      <div id="cloud2" class="cloud"></div>
    </div>  


	
    
    <div class="loginbody">
    
    <span class="systemlogo"></span> 
       
    <div class="loginbox">
    
    <ul>
    <li><input name="username" type="text" class="loginuser" value="admin" onclick="JavaScript:this.value=''"/></li>
    <li><input name="password" type="text" class="loginpwd" value="密码" onclick="JavaScript:this.value=''"/></li>
    <li><input type="button" class="loginbtn" value="登录"  id="loginButton"/><label>
    <input name="" type="checkbox" value="" checked="checked" />记住密码</label><label><a href="#">忘记密码？</a></label></li>
    </ul>
    
    
    </div>
    
    </div>
    
    
    
    <div class="loginbm">版权所有  2014 成都XXXXXX 备案号  </div>
	
    
</body>

</html>