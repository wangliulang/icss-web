package com.icss.framework.dao;

import java.util.List;

public interface IMyBatisBaseDAO{
	
	List<Object> find(String mapper, Object object);
	
	Object findOne(String mapper, Object object);
	
	void insertOne(String mapper, Object object);
	
	void insertBatch(String mapper, List<Object> objectList);
	
	void updateOne(String mapper, Object object);
	
	void updateBatch(String mapper, List<Object> objectList);
}
