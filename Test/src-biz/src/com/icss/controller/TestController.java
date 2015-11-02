package com.icss.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icss.framework.controller.BaseController;

@Controller  
public class TestController extends BaseController{
	@RequestMapping(value = "/helloworld")  
    public String helloworld() {  
		//System.out.println(this.baseService.find("test.mapper.selectAll", null));
        // return "success"; //跳转到success页面  
        return "index";
	}
	
	/**
	 * 访问路径为/Test/json?key1=123&key2=中文
	 * 通过url获取参数，返回对象自动转换为json对象
	 * @param key1
	 * @param key2
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/json")
	@ResponseBody
    public List json(
    		@RequestParam("key1") String key1,
            @RequestParam(value = "key2", required = false) String key2) {  
		Map map = new HashMap();
		map.put("123", "123");
		List list = new ArrayList();
		list.add(map);
		return list;
	}
	
	/**
	 * 获取json对象，可以接收json数组或单个对象
	 * 可以用map或pojo
	 * @param users
	 */
	@RequestMapping(value = "/sendjson")
	public void sendjson(@RequestBody Map[] users){
		System.out.println(users.length);
	}
}
