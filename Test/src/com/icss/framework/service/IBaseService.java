package com.icss.framework.service;

import java.util.List;

public interface IBaseService {
	
	public List<Object> findMybatis(String mapper, Object object);
	
	public Object findOneMybatis(String mapper, Object object);
	
	public void insertOneMybatis(String mapper, Object object);
	
	public void insertListMybatis(String mapper, List<Object> objectList);
	
	public void updateOneMybatis(String mapper, Object object);
	
	public void updateListMybatis(String mapper, List<Object> objectList);
	
	public List findHiber(String hql, Object[] param);
	
	public Object findOneHiber(String hql, Object[] param);
	
	public Object findByIdHiber(Class c, String id);
	
	public List findPageHiber(String hql, Object[] param, Integer page, Integer rows);
	
	public Long findCountHiber(String hql, Object[] param);
	
	public String insertOneHiber(Object object);
	
	public void saveOrUpdateHiber(Object object);
	
	public void deleteHiber(Object object);
}
