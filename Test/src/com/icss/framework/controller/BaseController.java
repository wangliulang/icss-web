package com.icss.framework.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.icss.framework.dao.BaseDAO;
import com.icss.framework.service.IBaseService;

public class BaseController {
	
	@Autowired
	public IBaseService baseService;
}
