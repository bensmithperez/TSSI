<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Admin</h1>
<%
try{
	if ((request.getAttribute("usuario") != null)){
		out.println("hola " + request.getAttribute("usuario"));
	} else {
		out.println("nada aqu'i");
	}
}
catch(Exception e){
	out.println("error");
}
%>
</body>
</html>