<ul>
	<li><a href="<%=request.getContextPath()%>/admin/home.jsp">Home</a></li>
	<li>Clientes
	<ul>
		<li><a href="<%=request.getContextPath()%>/admin/clientes/crear.jsp">Crear</a></li>
		<li><a href="<%=request.getContextPath()%>/admin/clientes/modificar.jsp">Modificar</a></li>
		<li><a href="<%=request.getContextPath()%>/admin/clientes/borrar.jsp">Borrar</a></li>
	</ul>
	</li>
	<li>Cuentas
	<ul>
		<li><a href="<%=request.getContextPath()%>/admin/cuentas/crear.jsp">Crear</a></li>
		<li><a href="<%=request.getContextPath()%>/admin/cuentas/modificar.jsp">Modificar</a></li>
		<li><a href="<%=request.getContextPath()%>/admin/cuentas/borrar.jsp">Borrar</a></li>
	</ul>
	</li>
	<li><a href="<%=request.getContextPath()%>/admin/asociarCuenta.jsp">Asociar Cuentas</a></li>
	<li>Servicios
	<ul>
		<li><a href="<%=request.getContextPath()%>/admin/servicios/crear.jsp">Crear</a></li>
		<li><a href="<%=request.getContextPath()%>/admin/servicios/modificar.jsp">Modificar</a></li>
		<li><a href="<%=request.getContextPath()%>/admin/servicios/borrar.jsp">Borrar</a></li>
	</ul>
	</li>
	<li><a href="<%=request.getContextPath()%>/includes/logout.jsp">Cerrar Sesión</a></li>
</ul>