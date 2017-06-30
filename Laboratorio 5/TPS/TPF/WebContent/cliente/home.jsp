<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Usuario</h1>
<%
try{
    if(session != null){  
	    if ((session.getAttribute("usuario") != null)){
	    	if ((Integer)session.getAttribute("tipo") == 1){
				out.println("hola " + session.getAttribute("usuario"));
	    	} else {
	    		session.invalidate();
	    		response.sendRedirect("login.jsp");
	    	}
		} else {
			session.invalidate();
    		response.sendRedirect("login.jsp");
		}
    }
}
catch(Exception e){
	out.println("error");
}
%>
</body>
<ul>
	<li>Home</li>
	<li>Movimientos</li>
	<li>Home</li>
	<li>Home</li>
</ul>
</html>