package com.icss.service.impl;

import org.springframework.stereotype.Service;

import com.icss.framework.service.IDefaultLoginService;

@Service(value="defaultLoginService")
public class CustomLoginServiceImpl implements IDefaultLoginService{

	/**
	 * �ж�ͬ�����Ƿ����
	 */
	public boolean isUserExist(String username) {
		return true;
	}

	/**
	 * ͨ���û��������û�����(Ĭ�Ϸ��ص������Ѿ�MD5���ܵ�����)
	 */
	public String findUserpassword(String username) {
		return "1234";
	}

}
