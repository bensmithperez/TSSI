<ul>
	<li><a href="<%=request.getContextPath()%>/admin/home.jsp">Home</a></li>
	<li class="dropdown">
		<a href="javascript:void(0)" class="dropbtn">Clientes</a>
		<div class="dropdown-content">
			<a href="<%=request.getContextPath()%>/admin/clientes/crear.jsp">Crear</a>
			<a href="<%=request.getContextPath()%>/admin/clientes/modificar.jsp">Modificar</a>
			<a href="<%=request.getContextPath()%>/admin/clientes/borrar.jsp">Borrar</a>
		</div>
	</li>
	<li class="dropdown">
		<a href="javascript:void(0)" class="dropbtn">Cuentas</a>
		<div class="dropdown-content">
			<a href="<%=request.getContextPath()%>/admin/cuentas/crear.jsp">Crear</a>
			<!-- <a href="<%=request.getContextPath()%>/admin/cuentas/modificar.jsp">Modificar</a>-->
			<a href="<%=request.getContextPath()%>/admin/cuentas/borrar.jsp">Borrar</a>
		</div>
	</li>
	<li class="dropdown">
		<a href="javascript:void(0)" class="dropbtn">Servicios</a>
		<div class="dropdown-content">
			<a href="<%=request.getContextPath()%>/admin/servicios/crear.jsp">Crear</a>
			<a href="<%=request.getContextPath()%>/admin/servicios/modificar.jsp">Modificar</a>
			<a href="<%=request.getContextPath()%>/admin/servicios/borrar.jsp">Borrar</a>
		</div>
	</li>
	<li><a href="<%=request.getContextPath()%>/admin/asociarCuenta.jsp">Asociar Cuenta</a></li>
	<li style="float:right"><a href="<%=request.getContextPath()%>/includes/logout.jsp">Cerrar Sesión</a></li>
</ul>