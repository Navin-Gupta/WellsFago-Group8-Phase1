<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib uri= "http://www.springframework.org/tags/form"  prefix="spring"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="security" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%-- To access info about logged in user --%>
<%-- info about logged in user is maintained in object principal --%>
<h1>Welcome <security:authentication property="principal.username"/></h1>
<h4><security:authentication property="principal.authorities"/></h4>
<hr/>
<spring:form action="${pageContext.request.contextPath}/logout" method="POST">
	<input type="submit" value="Logout">
</spring:form>

<security:authorize access="hasRole('STUDENT')">
	<hr/>
	<a href="${pageContext.request.contextPath}/student/home">Student Dashboard</a>
</security:authorize>

<security:authorize access="hasRole('MENTOR')">
<hr/>
<a href="${pageContext.request.contextPath}/mentor/home">Mentor Dashboard</a>
</security:authorize>

</body>
</html>