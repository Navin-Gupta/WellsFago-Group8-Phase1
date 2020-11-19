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
<h2>Provide profile info</h2>
<hr/>
<%--
	Map the model data with spring forms
	fine level/ field mapping
	all mapping will involve getter and setter
	1. When form loads
		call getter methods of class field
	2. When the form is submitted
		call setter method of class field	
 --%>
<spring:form action="profile-save" method="post" modelAttribute="student">
	<div>
		<div><spring:label path="name">Enter name</spring:label></div>
		<div><spring:input path="name" type="text" /></div>
	</div>
	<br/>
	<div>
		<div><spring:label path="email">Enter email</spring:label></div>
		<div><spring:input path="email" type="text" /></div>
	</div>
	<br/>
	
	<div>
		<div><spring:label path="country">Enter country</spring:label></div>
		<div>
			<spring:select path="country">
				<spring:option value="FR" label="France"/>
				<spring:option value="IN" label="India"/>
				<spring:option value="GR" label="Germany"/>
				<spring:option value="US" label="USA"/>
			</spring:select>
		</div>
	</div>
	<br/>
	<div>
		<input type="submit" value="Save" />
	</div>
		
</spring:form>
</body>
</html>