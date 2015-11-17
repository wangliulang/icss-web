package com.icss.framework.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service(value="backupBaseDao")
public class BackupBaseDAO implements IBaseDAO{
	
	private ApplicationContext ac = new FileSystemXmlApplicationContext("classpath:database-backup.xml");
	private SqlSessionFactory sessionFactory= (SqlSessionFactory)ac.getBean("sqlSessionFactory2");
	private SqlSession sqlSession = sessionFactory.openSession();
	
	
	
	/**
	 * 多条数据条件查询	 
	 * @param mapper
	 * @param object
	 */
	public List<Object> find(String mapper, Object object) {
		if(object != null) {
			return this.sqlSession.selectList(mapper, object);
		}
		return this.sqlSession.selectList(mapper);
	}
	
	/**
	 * 单条数据条件查询	 
	 * @param mapper
	 * @param object
	 */
	public Object findOne(String mapper, Object object) {
		if(object != null) {
			return this.sqlSession.selectOne(mapper, object);
		}
		return this.sqlSession.selectOne(mapper);
	}
	
	/**
	 * 插入单条数据
	 * @param mapper
	 * @param object
	 */
	public void insertOne(String mapper, Object object) {
		this.sqlSession.insert(mapper, object);
 	}
	
	/**
	 * 插入多条数据
	 * @param mapper
	 * @param objList
	 */
	public void insertBatch(String mapper, List<Object> objectList) {
		for(Object item : objectList) {
			this.sqlSession.insert(mapper, item);
		}
	}
	
	/**
	 * 更新单条数据
	 * @param mapper
	 * @param object
	 */
	public void updateOne(String mapper, Object object) {
		this.sqlSession.update(mapper, object);
 	}
	
	/**
	 * 更新多条数据
	 * @param mapper
	 * @param objList
	 */
	public void updateBatch(String mapper, List<Object> objectList) {
		for(Object item : objectList) {
			this.sqlSession.update(mapper, item);
		}
	}
}
