<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="model.bean.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 
	User user = (User)request.getSession().getAttribute("user");
	if (user!=null) {
%>
ID: <%=user.getId() %> <br>
		username: <%=user.getUsername() %> <br>
		realname: <%=user.getRealname() %> <br>
<%
	} 
%>
</body>
</html>