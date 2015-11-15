package com.icss.framework.service;

public interface ILoginService {
	boolean isUserExist(String username);
	
	String findUserpassword(String username);
}
