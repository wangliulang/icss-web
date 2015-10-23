package com.icss.framework.service;

import java.util.List;

public interface IBaseService {
	
	List<Object> find(String mapper, Object object);
	
	Object findOne(String mapper, Object object);
	
	void insertOne(String mapper, Object object);
	
	void insertList(String mapper, List<Object> objList);
	
	void updateOne(String mapper, Object object);
	
	void updateList(String mapper, List<Object> objList);
}
