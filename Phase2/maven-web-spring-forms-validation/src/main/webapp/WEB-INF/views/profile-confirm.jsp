<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Profile info saved successfully</h1>
<hr/>
<h2>Profile info</h2>
<h3>NAME : ${student.name}</h3>
<h3>EMAIL: ${student.email}</h3>
<h3>COUNTRY: ${student.country}</h3>
<h3>FREE PASSES: ${student.freePasses}</h3>
<h3>STUDENT CODE: ${student.studentCode}</h3>
<h3>FAVORITE LANGUAGES: </h3>
<ul>
	<core:forEach var="language" items="${student.favoriteLanguages}">
		<li>${language}</li>
	</core:forEach>
</ul>
</body>
</html>














