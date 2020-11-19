<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Profile information saved Successfully!!</h1>
<hr/>
<%-- SpEL will provide access over Model object --%>
<%-- will use getter methods --%>
<h2>Profile Details</h2>
<h3>NAME : ${employee.name}</h3>
<h3>EMAIL: ${employee.email}</h3>
<h3>CONTACT: ${employee.contact}</h3>
</body>
</html>