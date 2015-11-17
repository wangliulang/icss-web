package com.icss.framework.service;

public interface IDefaultLoginService {
	boolean isUserExist(String username);
	
	String findUserpassword(String username);
}
