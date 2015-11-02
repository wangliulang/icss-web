package com.icss.framework.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service(value="baseDao")
public class BaseDAO extends SqlSessionDaoSupport implements IBaseDAO{
	
	//private  ApplicationContext ac = new FileSystemXmlApplicationContext("classpath:applicationContext-database.xml");
	//private  SqlSessionFactory sessionFactory= (SqlSessionFactory)ac.getBean("sqlSessionFactory");
	
	@Autowired 
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {  
        super.setSqlSessionFactory(sqlSessionFactory);  
    }
	
	
	/**
	 * ��������������ѯ	 
	 * @param mapper
	 * @param object
	 */
	public List<Object> find(String mapper, Object object) {
		if(object != null) {
			return this.getSqlSession().selectList(mapper, object);
		}
		return this.getSqlSession().selectList(mapper);
	}
	
	/**
	 * ��������������ѯ	 
	 * @param mapper
	 * @param object
	 */
	public Object findOne(String mapper, Object object) {
		if(object != null) {
			return this.getSqlSession().selectOne(mapper, object);
		}
		return this.getSqlSession().selectOne(mapper);
	}
	
	/**
	 * ���뵥������
	 * @param mapper
	 * @param object
	 */
	public void insertOne(String mapper, Object object) {
		this.getSqlSession().insert(mapper, object);
 	}
	
	/**
	 * �����������
	 * @param mapper
	 * @param objList
	 */
	public void insertBatch(String mapper, List<Object> objectList) {
		for(Object item : objectList) {
			this.getSqlSession().insert(mapper, item);
		}
	}
	
	/**
	 * ���µ�������
	 * @param mapper
	 * @param object
	 */
	public void updateOne(String mapper, Object object) {
		this.getSqlSession().update(mapper, object);
 	}
	
	/**
	 * ���¶�������
	 * @param mapper
	 * @param objList
	 */
	public void updateBatch(String mapper, List<Object> objectList) {
		for(Object item : objectList) {
			this.getSqlSession().update(mapper, item);
		}
	}
}
