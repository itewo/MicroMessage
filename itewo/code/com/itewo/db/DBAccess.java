package com.itewo.db;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * 访问数据库类
 * @author E540
 *
 */
public class DBAccess {

	public SqlSession getSqlSession() throws IOException {
			//通过配置文件获取数据库链接信息；
			Reader reader = Resources.getResourceAsReader("com/itewo/config/Configuration.xml");
			//通过配置信息构建一个SqlSessionFactory
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			//通过SqlSessionFactory 打开一个数据库回话；
			SqlSession session = sqlSessionFactory.openSession();
			return session;
	}
}
