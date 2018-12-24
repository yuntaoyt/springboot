<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<% 
String path = request.getContextPath(); 
// 获得本项目的地址(例如: http://localhost:8080/MyApp/)赋值给basePath变量 
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; 

%> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript" src="<%=basePath %>js/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath %>js/jquery.plugin.js"></script>
<script type="text/javascript">
window.vst={};

/**
 * 页面跳转，带参数
 * @param url
 * @param param
 */
vst.formPost = function(url,param){
	if(typeof param=='object'){
		var params = jQuery.param(param);
		/*var url = url+"?"+params;*/
		if(!String.prototype.trim){
			String.prototype.trim = function () {
				return this.replace(/^\s\s*/, '' ).replace(/\s\s*$/, '' );
			}
		}
		if(url.indexOf("?") != -1){
			var	url = url+params;
		}else{
			var	url = url+"?"+params;
		}
	}
	if(typeof param=='string'){
		var url = url+"?"+param;
	}
	$('<form method="post" action="' + url + '"></form>').appendTo('body').submit().remove();
	//$.messager.progress('close');
};
$(function(){
	  //拿到点击按钮这几个方法   选择器的使用  click 事件的使用?
	  //直接拿到
	$("#bu").click(function(){
		  alert("sss");
	});
	 $(".t").click(function(){
		 alert("tttt");
	 }) 
	  // div  底下的元素 name='dj' 的元素
	$("#div [name='dj']").click(function(){
		alert("ss");
	})
	 //div  底下的id 等于bu  的元素
	$("#div #bu").click(function(){
		alert("ss-----");
	})
	 //查询方法来定位元素  find   children
	 $("#div").find("[name='dj']").click(function(){
		alert("ds&&&&&&&&"); 
	 })
	  // find   找到  id 是bu 的元素
	 $("#div").find("#bu").click(function(){
		 alert("tttttttttttttt")
	 })
	  //children   找到  name属性-dj  的元素
	 $("#div").children("[name='dj']").click(function(){
		 alert("hhhhhhh")
	 })
	  // children  找到 id  是bu 的元素
	 $("#div").children("#bu").click(function(){
		 alert("hhhhhhh2222")
	 })
	 
	// div  点击事件
	 $("#dt").click(function(){
		 alert("dt")
	 })
	 //div 双击事件
	 $("#t").dblclick(function(){
		 alert("rrrr");
	 })
	//-------------------------------------------------------------------------
	//鼠标获得焦点事件   
	/*  $("#test").focus(function(){
		alert("jjjjjjj");
	}) 
	//鼠标失去焦点
	$("#test").blur(function(){
		alert("ssstttt");
	})
	 //鼠标移到上面 事件
	$("#div").find("p[class!='t']").mouseover(function(){
		alert("sssttt")
	}) 
	//鼠标移除在上面 事件
	$("#div").find("p[class!='t']").mouseout(function(){
		alert("sssrrrrrrrr----------");
	}) */
	//键盘事件的使用  回车
	$("#test1").keydown(function(e){
		if(e.keyCode==13){
			alert("sss");
		}
	})
	$("#se").change(function(){
		alert("s");
	})
	
	//拿到它的属性值
	 $(".t").click(function(){
		var a =$(".t").attr("class");
		alert(a);
	}) 
	//给属性值赋值
	$(".t").click(function(){
		//赋值
		$(".t").attr("id","st")
		//拿属性值看下对不对
		var a =$(".t").attr("id");
		alert(a);
	})
	
	$.ajax({
		  type: "POST",
		  url: "/show",
		  data: "name=John&location=Boston",
		  success: function(msg){
		     alert( "Data Saved: " + msg );
		  }
	 })
	
})
 function show(){
	 var  s  ={};
	 s.name="yn";
	 vst.formPost("/test/show",s);
	 }
 function show1(){
	 var  s="<p>uuuuuuuuuuu</p>"
	 +"<p>sssssssssssssss</p>";
	 $(s).appendTo("#ts");
 }	
 function show2(){
    var  s =[];
    s[0]="yyy";
    s[1]="yyys";
    $(s).each(function(i,t){
    	alert(t)
    })
 }	
 function show3(){
   var s ={};
   s.name="ddd";
   s.id=1;
   $(s).each(function(i,t){
	   alert(i);
   })
 }
 
 function  show4(){
	 $("#i").attr("disabled",true);
	 $("#i").submit();
 }
 function  show5(){
	 alert("ss");
	 debugger
	 var form=document.getElementById("uploadForm");
     var formData=new FormData(form);
     $.ajax({
		  type: "POST",
		  url: "/test/show",
		  contentType: false,
          processData: false,
		  data: formData,
		  success: function(msg){
		     alert( "Data Saved: " + msg );
		  }
	 })
	
 }
 
</script>

</head>
<body>
    <input type="button" value="点击事件"  name="dj" id="bu" onclick="show2()">
   <div id="ts"></div>
    <div id="div">
       <input type="button" value="点击事件"  name="dj" id="bu" onclick="show()">
        <input type="button" value="点击事件"  name="dj" id="bu" onclick="show1()">
       <input type="text" id="test">
       <select id="se">
          <option value="1">云涛</option>
          <option value="2">王莹</option>
       </select>
       
       <p class="t" id="t">鼠标焦点事件</p>
       <div id="dt">云国焘</div>
       <p>鼠标移到上面</p>
       <input type="text" id="test1">
       
       <div>
         <input type="checkbox">
         <input type="checkbox">
          <input type="checkbox">
          <input type="checkbox">
         <input type="checkbox">
             
       </div>
          <input type="button" value="点击事件" onclick="show3()">
         <input type="button" value="点击事件" id="i" onclick="show4()">
   
         <form action="" method="post"  id="uploadForm" enctype="multipart/form-data">
           <input type="text" name="sname">
           <input type="file" name="filename">
           <button onclick="show5()">提交</button>
         </form>
       
    </div>
</body>
</html>