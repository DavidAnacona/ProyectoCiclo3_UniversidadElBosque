<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import='co.edu.unbosque.frontend.Usuarios' %>
<%@ page import='java.util.ArrayList' %>
<html>
<head>
<meta charset="UTF-8">
<title>Tienda Generica</title>
</head>
<body>
	<p>Listado de usuarios</p>
	<table>
		<tr>
			<td><label>Cedula</label></td>
			<td><label>Nombre</label></td>
			<td><label>Correo</label></td>
			<td><label>Usuario</label></td>
			<td><label>Password</label></td>
		</tr>
		<%
		ArrayList<Usuarios> lista = (ArrayList<Usuarios>) request.getAttribute("lista");
		for (Usuarios usuario:lista){
		%>
		<tr>
			<td><%= usuario.getCedula_usuario() %></td>
			<td><%= usuario.getNombre_usuario()%></td>
			<td><%= usuario.getEmail_usuario()%></td>
			<td><%= usuario.getUsuario()%></td>
			<td><%= usuario.getPassword()%></td>
		</tr>
		<%
		}
		%>
	</table>
</body>
</html>