package com.icss.framework.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.icss.framework.dao.IBaseDAO;
import com.icss.framework.service.IBaseService;

@Service(value="backupBaseService")
public class BackupBaseServiceImpl implements IBaseService {
	@Autowired
	private IBaseDAO backupBaseDao;
	
	public List<Object> find(String mapper, Object object){
		return backupBaseDao.find(mapper, object);
	}
	
	public Object findOne(String mapper, Object object) {
		// TODO Auto-generated method stub
		return backupBaseDao.findOne(mapper, object);
	}

	public void insertOne(String mapper, Object object) {
		backupBaseDao.insertOne(mapper, object);
	}
	
	@Transactional
	public void insertList(String mapper, List<Object> objectList){
		backupBaseDao.insertBatch(mapper, objectList);
	}

	public void updateOne(String mapper, Object object) {
		backupBaseDao.updateOne(mapper, object);
	}
	
	@Transactional
	public void updateList(String mapper, List<Object> objectList) {
		backupBaseDao.updateBatch(mapper, objectList);
	}
}
