package com.icss.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.icss.framework.service.impl.BaseServiceImpl;
import com.icss.service.ITestService;
import com.icss.service.ITestTwoService;

@Service(value="testTwoService")
public class TestTwoServiceImpl extends BaseServiceImpl implements ITestTwoService{
	
	@Autowired
	private ITestService testService;
	
	public void insertUser(){
		Map user = new HashMap();
		user.put("username", "username1");
		testService.insertUser();
		this.insertOne("test.blob.insertUser", user);
	}
}
