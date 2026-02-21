<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.ecommerce.model.User" %>

<%
User user = (User) session.getAttribute("user");

if(user == null){
    response.sendRedirect("login.jsp");
    return;   // 🔥 VERY IMPORTANT (Stops JSP Execution)
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>

<h2>Welcome <%= user.getName() %> 🎉</h2>

<a href="product.jsp">Shop Now</a>

</body>
</html>