package com.icss.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.icss.framework.controller.BaseController;

@Controller  
public class TestController extends BaseController{
	@RequestMapping(value = "/helloworld")  
    public String helloworld() {  
		System.out.println(this.baseService.find("test.mapper.selectAll", null));
        // return "success"; //��ת��successҳ��  
        return "index";
	}
}
