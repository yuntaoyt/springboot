<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
<script type="text/javascript" src="<%=basePath %>js/Test.js"></script>
</head>
<script type="text/javascript">
function  show(){
	var  list  =[];   //声明的是数组
	var  b  ={};      //声明的是对象
	b.name='yuntao';  //属性
	b.id=1;           //属性
	list.push(b);     //把对象添加到数组中
	
	//转换
	var  json =JSONObject.stringfiy(list);
	alert(json);
}

</script>
<body>
  <form action="#">
  	<select name="selects">
  		 <c:forEach items="${list}" var="t" varStatus="s">
  			<option value="${t.id}"  <c:if test="${t.id eq '02' }">selected="selected"</c:if>>${t.name}</option>
  		</c:forEach>
  	</select>
  	<c:choose>
  	   <c:when test="${name eq 'y'}">
  	      <p> yyyyyy</p>
  	   </c:when>
  	   <c:when test="${name eq 'y'}">
  	      <p>ttttttt</p>
  	   </c:when>
  	   <c:otherwise>
  	      <p>t</p>
  	   </c:otherwise>
  	</c:choose>
  	<input type="button" onclick="show()" value="提交">
  </form>
</body>
</html>