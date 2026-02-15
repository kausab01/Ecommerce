<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="Registerservlet" method="post">
Name : <input type="text" name="name"><br>
@Email : <input type="email" name="mail"><br>
Password : <input type="password" name="pass"><br>
 <button type="submit">Register</button> 
</form>

<a href="login.jsp" >Already Have Account ? Login..</a>
</body>
</html>