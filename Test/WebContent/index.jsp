<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="UTF-8">
	<title>Basic Layout - jQuery EasyUI Demo</title>
	<link rel="stylesheet" type="text/css" href="easyui/themes/metro/easyui.css">
	<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css">
	<script type="text/javascript" src="easyui/jquery.min.js"></script>
	<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
</head>
	
	
	<body class="easyui-layout">
		<div data-options="border:false,region:'north'" style="height:100px">
			<div style="background-color:black;height:100%;width:100%;color:white;">
				<a href="j_spring_security_logout">登出</a>
			</div> 
		</div>
		<div data-options="border:true,region:'west'" title=" " style="width:180px" >
			<div class="easyui-accordion" data-options="fit:true,border:false">
				<div title="提交表单" data-options="selected:true" style="padding:10px;">
					字那么难看
				</div>
				<div title="列表" style="padding:10px;">
					content2
				</div>
				<div title="上传下载" style="padding:10px">
					content3
				</div>
			</div>
		</div>
		<div data-options="border:true,region:'center'" title=" " >
			<div class="easyui-tabs" data-options="fit:true,border:false,plain:true">
				<div title="About" data-options="" style="padding:10px">
					<input type="button" id="get" value="get" />
					<input type="button" id="send" value="send" />
				</div>
				<div title="DataGrid" data-options="closable:true" style="padding:5px">
				</div>
				
			</div>
		</div>
	</body>
<script type="text/javascript">
	$("#get").on("click", function() {
		$.post("json?key1=123&key2=中文", function(data){
			var json = eval(data);
			alert(json.length);
		});
	});
	
	$("#send").on("click", function() {
		var saveDataAry=[];  
	    var data1={"userName":"test","address":"gz"};  
	    var data2={"userName":"ququ","address":"gr"};  
	    saveDataAry.push(data1);  
	    saveDataAry.push(data2);         
	    $.ajax({ 
	        type:"POST", 
	        url:"sendjson", 
	        dataType:"json",      
	        contentType:"application/json",               
	        data:JSON.stringify(saveDataAry), 
	        success:function(data){ 
	           
	        },
	        error:function(data){ 
	           alert("oh no!");
	        }
	     });
	});
</script>
</html>