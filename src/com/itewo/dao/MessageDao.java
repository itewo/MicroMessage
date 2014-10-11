package com.itewo.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.itewo.bean.Message;
import com.itewo.db.DBAccess;

public class MessageDao {
	
	/**
	 * 根据查询条件查询消息列表 (Mybatis 方式)
	 * @param command
	 * @param description
	 * @return
	 */
	
	public List<Message> queryMessageList(Message message){
		DBAccess dbaccess = new DBAccess();
		SqlSession sqlsession =null;
		List <Message> messageList = new ArrayList<Message>();
		try {
			sqlsession = dbaccess.getSqlSession();
			//通过sqsession 执行sql语句;
			messageList = sqlsession.selectList("Message.queryMessageList",message);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(sqlsession != null){
				sqlsession.close();
			}
		}
		return messageList;
	}
	
	/**
	 * 根据查询条件查询消息列表 (普通JDBC方式)
	 * @param command
	 * @param description
	 * @return
	 */
/*	public List<Message> queryMessageList(String command,String description){
		List <Message> messageList = new ArrayList<Message>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/micro_message","root","root");
			StringBuilder  sql = new StringBuilder("select id,command,description,content from message where 1=1 "); 
			List <String> paramList = new ArrayList<String>();
			//判断获取的command 与description 是否为空;
			if(command!=null&&!"".equals(command.trim())){
				sql.append("and command =?");
				paramList.add(command);		
			};
			if(description!=null&&!"".equals(description.trim())){
				sql.append("and description like '%' ? '%'");
				paramList.add(description);
			};
			PreparedStatement statement  =conn.prepareStatement(sql.toString());
			for (int i = 0; i < paramList.size(); i++) {
				statement.setString(i+1,paramList.get(i));
			};
			ResultSet  rs  = statement.executeQuery();
			while(rs.next()){
				Message message = new Message();
				message.setId(rs.getString("id"));
				message.setCommand(rs.getString("command"));
				message.setDescription(rs.getString("description"));
				message.setContent(rs.getString("content"));
				messageList.add(message);
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return messageList;
	}*/
}
