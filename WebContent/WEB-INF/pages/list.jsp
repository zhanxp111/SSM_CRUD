<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
		pageContext.setAttribute("ctp", request.getContextPath());
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>手机列表</title>
<script type="text/javascript" src="${ctp }/scripts/jquery-1.9.1.min.js"></script>
</head>
<body>
	
	<h1>手机列表</h1>
	<table border="1" cellpadding="5" cellspacing="0">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>price</th>
			<th>color</th>
			<th>EDIT</th>
			<th>DELETE</th>
		</tr>
		<c:forEach items="${phones }" var="phone">
			<tr>
				<td>${phone.id }</td>
				<td>${phone.name}</td>
				<td>${phone.price }</td>
				<td>${phone.color }</td>
				<td><a href="${ctp }/phone/${phone.id }">edit</a></td>
				<td><a href="${ctp }/phone/${phone.id }" class="delBtn">delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<a href="${ctp }/toaddpage">添加手机</a>
	
	<form id="deleteForm" action="${ctp }/phone/${phone.id }" method="post">
		<input type="hidden" name="_method" value="DELETE" /> 
	</form>
	<script type="text/javascript">
		$(function(){
			$(".delBtn").click(function(){
				//1、改变表单的action指向
				$("#deleteForm").attr("action",this.href);
				//2、提交表单
				$("#deleteForm").submit();
				return false;
			});
		});
	</script>
</body>
</html>