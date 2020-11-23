<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Login here...</h2>
<hr/>
<spring:form action="${pageContext.request.contextPath}/validate" method="POST">
	<div>
		<div><label>Enter login Id</label></div>
		<div><input type="text" name="username" /></div>
	</div>
	<div>
		<div><label>Enter Password</label></div>
		<div><input type="password" name="password" /></div>
	</div>
	<br/>
	<div>
		<input type="submit" value="Login" />
	</div>
</spring:form>
</body>
</html>