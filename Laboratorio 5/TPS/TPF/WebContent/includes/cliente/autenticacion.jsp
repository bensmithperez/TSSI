<%
try{
    if(session != null){  
	    if ((session.getAttribute("usuario") != null)){
	    	if ((Integer)session.getAttribute("tipo") == 1){
	    		//System.err.println("es 1");
				out.println("hola " + session.getAttribute("usuario"));
	    	} else {
	    		session.invalidate();
	    		response.sendRedirect("login.jsp");
	    	}
		} else {
			//System.err.println("no hay usuario");
			session.invalidate();
    		response.sendRedirect("login.jsp");
		}
    }
}
catch(Exception e){
	out.println("error");
}
%>