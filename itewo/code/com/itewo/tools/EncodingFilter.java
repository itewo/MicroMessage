package com.itewo.tools;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义字符编码过滤器  
 * @author E540
 *
 */
public class EncodingFilter implements Filter{
	 private FilterConfig filterConfig = null;
	 private String encoding = null;
	 
	 //初始化
	 public void init(FilterConfig filterConfig) throws ServletException {
	  this.filterConfig = filterConfig; 
	  this.encoding  = filterConfig.getInitParameter("encoding");
	  
	 }
	 public void doFilter(ServletRequest request, ServletResponse response,
	   FilterChain filterChain) throws IOException, ServletException {
	  
	  HttpServletRequest req = (HttpServletRequest) request;
	  HttpServletResponse res = (HttpServletResponse) response;
	  //设置请求字符编码 
	  request.setCharacterEncoding(encoding); 
	  //设置响应字符编码
	  response.setCharacterEncoding(encoding); 
	    //如果是Get方式提交 
	    if("get".equalsIgnoreCase(req.getMethod().trim().toString())){
	     //对请求进行包装,完成URL中参数的编码转换
	     req = new GetHttpServletRequestWrapper(req,encoding);
	    }
	    
	     //执行下一个过滤器
	  filterChain.doFilter(req, res);
	 }
	 //销毁
	 public void destroy() {
	  this.filterConfig = null;
	  this.encoding = null;
	  
	 }
	 
	 public FilterConfig getFilterConfig() {
	  return filterConfig;
	 }
	 
	 public void setFilterConfig(FilterConfig filterConfig) {
	  this.filterConfig = filterConfig;
	 }
	 
	}
