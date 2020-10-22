<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>JSP Environment...</h1>
<%--
	Comment
 --%>
<%
	// comment
	String str = "Hello";

	//request.getParameter("logid");
	// response.
	// Does have additional support of multiple predeclared object

%>
<%!

	private String data = "";

	public static void sfun(){
		
	}

	public void init(){
		
	}
	public void destroy(){
		
	}
	
%>

<h2><%=str %></h2>

<%
	for(int i=1;i<=10;i++) {
%>
	<input type="text" id="txt<%=i %>"  value="<%=str%>"/>
	<br/><br/>

<% } %>	
	
</body>
</html>