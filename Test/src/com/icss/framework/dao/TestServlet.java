package com.icss.framework.dao;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.icss.framework.AuthenticationService;

public class TestServlet extends HttpServlet {

	@Autowired
	private BaseDAO baseDao;
	
	@Autowired
	private AuthenticationService authService;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		/*authService.loadUserByUsername("1234");
		System.out.println(baseDao.find("test.mapper.selectAll").size());*/
	}
}
