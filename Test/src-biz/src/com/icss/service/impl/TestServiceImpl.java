package com.icss.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.icss.framework.service.impl.BaseServiceImpl;
import com.icss.model.WuyeBaoxiu;
import com.icss.service.ITestService;

@Service(value="testService")
public class TestServiceImpl extends BaseServiceImpl implements ITestService{
	public void insertUser(){
		/*Map user = new HashMap();
		user.put("username", "username");
		this.insertOneMybatis("test.blob.insertUser", user);
		int a = 1/0;
		this.insertOneMybatis("test.blob.insertUser", user);*/
		WuyeBaoxiu baoxiu = new WuyeBaoxiu();
		
		baoxiu = new WuyeBaoxiu();
		baoxiu.setId("b12345");
		this.insertOneMybatis("test.blob.insertBaoxiu", baoxiu);
		
		baoxiu.setId("b123");
		this.insertOneHiber(baoxiu);
		WuyeBaoxiu a = (WuyeBaoxiu)this.findByIdHiber(WuyeBaoxiu.class, "67113fc10702468a9d6c1697592e4cd3");
		System.out.println(a.getBaoxiuNeirong());
		int b = 1/0;
		baoxiu = new WuyeBaoxiu();
		baoxiu.setId("b1234");
		this.insertOneHiber(baoxiu);
		
	}
}
