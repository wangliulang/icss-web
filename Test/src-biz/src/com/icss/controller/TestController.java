package com.icss.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icss.framework.controller.BaseController;

@Controller  
public class TestController extends BaseController{
	
	@Autowired
	private  HttpServletRequest request;
	
	@RequestMapping(value = "/helloworld")  
    public String helloworld() {  
		System.out.println(request.getContextPath());
		System.out.println("**************************************" + this.baseService.find("test.mapper.selectAll", null));
        // return "success"; //��ת��successҳ��  
        return "index";
	}
	
	/**
	 * ����·��Ϊ/Test/json?key1=123&key2=����
	 * ͨ��url��ȡ���������ض����Զ�ת��Ϊjson����
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
	 * ��ȡjson���󣬿��Խ���json����򵥸�����
	 * ������map��pojo
	 * @param users
	 */
	@RequestMapping(value = "/sendjson")
	public void sendjson(@RequestBody Map[] users){
		System.out.println(users.length);
		while(true) {
			try {
				this.baseService.find("test.mapper.selectAll", null);
	//			Class.forName("com.mysql.jdbc.Driver");
	//			String url="jdbc:mysql://121.40.192.196:3306/mymjxt?user=root&password=jifang1303&useUnicode=true&characterEncoding=UTF-8";
	//			
	//			Connection con = DriverManager.getConnection(url);
	//			Statement stmt = con.createStatement();
	//			String query = "select * from s_mjxt_record_info";
	//			ResultSet rs=stmt.executeQuery(query);
	//			con.close();
	//			System.out.println("ok/***************************************/");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				break;
			}
		}
	}
}
