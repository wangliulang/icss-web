package com.icss.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.icss.framework.controller.BaseController;
import com.icss.service.ITestTwoService;
import com.icss.service.impl.TestTwoServiceImpl;

@Controller  
public class TestController extends BaseController{
	
	@Autowired
	private  HttpServletRequest request;
	
	@Autowired
	private ITestTwoService testTwoService;
	
	@RequestMapping(value = "/helloworld")  
    public String helloworld() {  
		System.out.println(request.getContextPath());
		System.out.println("**************************************" + this.baseService.find("test.mapper.selectAll", null));
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
		}
	}
	
	@RequestMapping(value = "/blob")
    public void testblob(HttpServletRequest request, HttpServletResponse response) {
		//创建一个通用的多部分解析器  
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());  
        //判断 request 是否有文件上传,即多部分请求  
        if(multipartResolver.isMultipart(request)){  
            //转换成多部分request    
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)request;  
            //取得request中的所有文件名  
            Iterator<String> iter = multiRequest.getFileNames();  
            while(iter.hasNext()){  
                //记录上传过程起始时的时间，用来计算上传时间  
                int pre = (int) System.currentTimeMillis();  
                //取得上传文件  
                MultipartFile file = multiRequest.getFile(iter.next());  
                if(file != null){  
                    //取得当前上传文件的文件名称  
                    String myFileName = file.getOriginalFilename();
                    //如果名称不为“”,说明该文件存在，否则说明该文件不存在  
                    if(myFileName.trim() !="") {
                    	Map param = new HashMap();
                        byte[] b;
						try {
							b = file.getBytes();
							if (b == null || b.length == 0) { 

	                        }else {
	                        	param.put("testblob", b);
	                        	this.baseService.insertOne("test.blob.insertBlob", param);
	                        }
						} catch (IOException e1) {
							e1.printStackTrace();
						}
                        /*System.out.println(myFileName);  
                        //重命名上传后的文件名  
                        String fileName = "demoUpload" + file.getOriginalFilename();  
                        //定义上传路径  
                        String path = "D:/" + fileName;  
                        File localFile = new File(path);  
                        try {
							file.transferTo(localFile);
						} catch (IllegalStateException | IOException e) {
							e.printStackTrace();
						}  */
                    }  
                }  
                //记录上传该文件后的时间  
                int finaltime = (int) System.currentTimeMillis();  
                System.out.println(finaltime - pre);  
            }  
              
        }  
	}
	
	@RequestMapping(value = "/testtran")
	public void testTran(){
		testTwoService.insertUser();
	}
}
