<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>添加手机</h1>
<%
	pageContext.setAttribute("ctp", request.getContextPath());
%>
<form:form action="${ctp }/phone" modelAttribute="phone" method="POST">
	name:<form:input path="name"/><br/>
	price:<form:input path="price"/><br/>
	color:<form:input path="color"/></br>
	<input type="submit" value="保存"/>
</form:form>




</body>
</html>