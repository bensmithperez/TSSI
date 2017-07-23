<%
try{
    if(session != null){  
	    if ((session.getAttribute("usuario") != null)){
	    	if ((Integer)session.getAttribute("tipo") == 1){
				out.println("hola " + session.getAttribute("usuario"));
	    	} else {
	    		session.invalidate();
	    		response.sendRedirect(request.getContextPath()+"/login.jsp");
	    	}
		} else {
			session.invalidate();
    		response.sendRedirect(request.getContextPath()+"/login.jsp");
		}
    }
}
catch(Exception e){
	out.println("error");
}
%>