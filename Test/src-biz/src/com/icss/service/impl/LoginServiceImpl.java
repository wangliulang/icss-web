package com.icss.service.impl;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;

import com.icss.framework.service.ILoginService;

@Service(value="loginService")
public class LoginServiceImpl implements ILoginService{

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
