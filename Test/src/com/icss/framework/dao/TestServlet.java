package com.icss.framework.dao;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.icss.framework.service.IBaseService;

public class TestServlet extends HttpServlet {

	@Autowired
	private IBaseService backupBaseService;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		/*authService.loadUserByUsername("1234");
		System.out.println(baseDao.find("test.mapper.selectAll").size());*/
		//System.out.println(backupBaseService.toString());
		System.out.println(request.getParameter("a"));
		ServletContext servletContext = this.getServletContext();  
        WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(servletContext);  
        System.out.println(context.getBean("backupBaseService").toString());
        try {
			response.getWriter().write("1");
			response.getWriter().flush();
			response.getWriter().close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
