package com.itewo.service;

import java.util.List;

import com.itewo.bean.Message;
import com.itewo.dao.MessageDao;

public class ListService {
	
	/**
	 *  列表相关业务操作
	 * @param command
	 * @param description
	 * @return
	 */
	 public List <Message>queryMessageList(String command,String description){
		 MessageDao  messagedto = new MessageDao();
		 Message  message = new Message();
		 message.setCommand(command);
		 message.setDescription(description);
		 return  messagedto.queryMessageList(message);
	 }
}
