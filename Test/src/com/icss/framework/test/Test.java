package com.icss.framework.test;

import com.icss.framework.dao.BackupBaseDAO;
import com.icss.framework.dao.IBaseDAO;
import com.icss.framework.service.IBaseService;
import com.icss.framework.service.impl.BackupBaseServiceImpl;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IBaseDAO dao = new BackupBaseDAO();
		System.out.println(dao.find("test.mapper.selectAll", null).toString());
		
		IBaseService service = new BackupBaseServiceImpl();
		System.out.println(service.find("test.mapper.selectAll", null).toString());
	}

}
