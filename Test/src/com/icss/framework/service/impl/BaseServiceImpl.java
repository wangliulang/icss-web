package com.icss.framework.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.icss.framework.dao.BaseDAO;
import com.icss.framework.service.IBaseService;

@Service(value="baseService")
@Transactional(propagation=Propagation.REQUIRED)
public class BaseServiceImpl implements IBaseService{
	@Autowired
	private BaseDAO baseDao;
	
	public List<Object> find(String mapper, Object object){
		return baseDao.find(mapper, object);
	}
	
	public Object findOne(String mapper, Object object) {
		// TODO Auto-generated method stub
		return baseDao.findOne(mapper, object);
	}

	public void insertOne(String mapper, Object object) {
		baseDao.insertOne(mapper, object);
	}
	
	public void insertList(String mapper, List<Object> objectList){
		baseDao.insertBatch(mapper, objectList);
	}

	public void updateOne(String mapper, Object object) {
		baseDao.updateOne(mapper, object);
	}
	
	public void updateList(String mapper, List<Object> objectList) {
		baseDao.updateBatch(mapper, objectList);
	}
}
