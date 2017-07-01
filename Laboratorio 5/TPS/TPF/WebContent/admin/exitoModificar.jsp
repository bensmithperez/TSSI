<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="../../includes/admin/head.jsp" %>
<body>
<h1>Admin</h1>
<h2>Exito</h2>
<%@ include file="../../includes/admin/autenticacion.jsp" %>
<%@ include file="../../includes/admin/menu.jsp" %>

<p id="exito">
<%
try{
	if (request.getAttribute("exito") != null){
		out.println("El registro fue modificado exitosamente!");
	}
}
catch(Exception e){
	out.println("error");
}
%>
</p>
<%@ include file="../../includes/admin/footer.jsp" %>
</body>
</html>