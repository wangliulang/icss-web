package com.icss.framework.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.icss.framework.dao.IHibernateBaseDAO;
import com.icss.framework.dao.IMyBatisBaseDAO;
import com.icss.framework.service.IBaseService;

@Service(value="baseService")
public class BaseServiceImpl implements IBaseService{
	
	@Autowired
	private IMyBatisBaseDAO mybatisBaseDao;
	
	@Autowired
	private IHibernateBaseDAO hibernateBaseDao;
	
	public List<Object> findMybatis(String mapper, Object object){
		return mybatisBaseDao.find(mapper, object);
	}
	
	public Object findOneMybatis(String mapper, Object object) {
		return mybatisBaseDao.findOne(mapper, object);
	}

	public void insertOneMybatis(String mapper, Object object) {
		mybatisBaseDao.insertOne(mapper, object);
	}
	
	public void insertListMybatis(String mapper, List<Object> objectList){
		mybatisBaseDao.insertBatch(mapper, objectList);
	}

	public void updateOneMybatis(String mapper, Object object) {
		mybatisBaseDao.updateOne(mapper, object);
	}
	
	public void updateListMybatis(String mapper, List<Object> objectList) {
		mybatisBaseDao.updateBatch(mapper, objectList);
	}
	
	public List findHiber(String hql, Object[] param) {
		return hibernateBaseDao.find(hql, param);
	}
	
	public Object findOneHiber(String hql, Object[] param) {
		return hibernateBaseDao.findOne(hql, param);
	}
	
	public Object findByIdHiber(Class c, String id) {
		return hibernateBaseDao.findById(c, id);
	}
	
	public List findPageHiber(String hql, Object[] param, Integer page, Integer rows) {
		return hibernateBaseDao.find(hql, param, page, rows);
	}
	
	public Long findCountHiber(String hql, Object[] param) {
		return hibernateBaseDao.count(hql, param);
	}
	
	public String insertOneHiber(Object object) {
		return hibernateBaseDao.save(object).toString();
	}
	
	public void saveOrUpdateHiber(Object object) {
		hibernateBaseDao.saveOrUpdate(object);
	}
	
	public void deleteHiber(Object object) {
		hibernateBaseDao.delete(object);
	}
}
