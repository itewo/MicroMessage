package com.itewo.tools;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 1、获取时间戳；
 * 2、时间戳与日期的格式的转换
 * @author E540
 *
 */
public class TimeMillis {

	/**
	 * 时间戳获取有三种方式：
	 * 1：System.currentTimeMillis();   
	 * 2：Calendar.getInstance().getTimeInMillis();  
	 * 3：new Date().getTime();  
	 *  第一种方式效率最高;
	 * @return
	 */
	public Long getTimeMillis(){
		return System.currentTimeMillis();
	}
	
	/**
	 * 将时间戳转换为指定格式的日期格式
	 * @param time 时间戳
	 * @param DateFormat 格式化方式；如："yyyy-MM-dd hh:mm:ss"
	 * @return 指定的格式的日期
	 */
	public String formatDate(Long time,String DateFormat){
		SimpleDateFormat sdf = new SimpleDateFormat(DateFormat);
		return sdf.format(new Date(time));
	}
	
}
