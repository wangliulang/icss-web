package com.icss.service.impl;

import org.springframework.stereotype.Service;

import com.icss.framework.service.IDefaultLoginService;

@Service(value="defaultLoginService")
public class CustomLoginServiceImpl implements IDefaultLoginService{

	/**
	 * 判断同户名是否存在
	 */
	public boolean isUserExist(String username) {
		return true;
	}

	/**
	 * 通过用户名返回用户密码(默认返回的密码已经MD5加密的密码)
	 */
	public String findUserpassword(String username) {
		
		org.springframework.security.authentication.encoding.Md5PasswordEncoder a = new org.springframework.security.authentication.encoding.Md5PasswordEncoder();
		System.out.println(a.encodePassword("123456", null));
		return "e10adc3949ba59abbe56e057f20f883e";// 123456
	}

}
