package com.icss.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.icss.framework.service.impl.BaseServiceImpl;
import com.icss.service.ITestService;

@Service(value="testService")
public class TestServiceImpl extends BaseServiceImpl implements ITestService{
	public void insertUser(){
		Map user = new HashMap();
		user.put("username", "username");
		this.insertOne("test.blob.insertUser", user);
		int a = 1/0;
		this.insertOne("test.blob.insertUser", user);
	}
}
