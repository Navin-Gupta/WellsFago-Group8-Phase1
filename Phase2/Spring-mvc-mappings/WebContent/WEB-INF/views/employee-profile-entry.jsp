<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Profile management</h2>
<hr/>
<form action="save-profile" method="post">
	<div>
		<div><label>Enter name</label></div>
		<div><input type="text" name="name" /></div>
	</div>
	<br/>
	<div>
		<div><label>Enter email</label></div>
		<div><input type="text" name="email" /></div>
	</div>
	<br/>
	<div>
		<div><label>Enter contact</label></div>
		<div><input type="text" name="contact" /></div>
	</div>
	<br/>
	<div>
		<input type="submit" value="Save"> 
	</div>
	
</form>
</body>
</html>