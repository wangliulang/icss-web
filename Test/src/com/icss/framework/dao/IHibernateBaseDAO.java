package com.icss.framework.dao;

import java.io.Serializable;
import java.util.List;

public interface IHibernateBaseDAO {
	public Serializable save(Object object);
	
	public void update(Object object);
	
	public void saveOrUpdate(Object object);
	
	public Object findById(Class c, Serializable id);
	
	public Object findOne(String hql, Object[] param);
	
	public List find(String hql, Object[] param);
	
	public List find(String hql, Object[] param, Integer page, Integer rows);
	
	public Long count(String hql, Object[] param);
	
	public void delete(Object object);
}
