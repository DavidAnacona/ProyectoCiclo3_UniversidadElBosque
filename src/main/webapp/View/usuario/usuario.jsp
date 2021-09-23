<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Tienda generica</title>
	<style type="text/css">
	<%@ include file="style.css" %>
	</style>
</head>
<body>
	<header id="header">
			<jsp:include page="../menu/menu.jsp" />
	</header>
	<main>
		<section class="main--formulario-registro">
			<h2>Registrar usuario</h2>
			<form action="${pageContext.request.contextPath}/validacionLogin" method="get"   class="formulario--registro-form">
				<label for="cedula" class="formulario--registro-label">
					<span>Cedula</span>
					<input type="text" name="cedula" id="cedula" class="formulario--registro-campo" placeholder="Ingresa tu cedula" />
				</label>
				<label for="nombre" class="formulario--registro-label">
					<span>Nombre</span>
					<input type="text" name="nombre" id="nombre" class="formulario--registro-campo" placeholder="Ingresa tu nombre completo" />
				</label>
				<label for="correo" class="formulario--registro-label">
					<span>Correo</span>
					<input type="text" name="correo" id="correo" class="formulario--registro-campo" placeholder="Ingresa tu correo electrónico" />
				</label>
				<label for="usuario" class="formulario--registro-label">
					<span>Usuario </span>
					<input class="formulario--registro-campo" name="usuario" id="usuario" type="text" placeholder="Ingresa tu usuario" />
				</label>
				<label for="password" class="formulario--registro-label">
					<span>Password </span>
					<input class="formulario--registro-campo" name="password" id="password" type="password" placeholder="Ingresa tu contraseña"/>
				</label>
				<input class="formulario--registro-submit" name="Agregar" id="button" type="submit" value="Registrar" />
				<button type="submit" name="Listar">Listar usuarios</button>
			</form>
		</section>
		
		<section class="main--view--usuarios">
			<section class="main--view-consultas">
				<select name="tipo_consulta">
					<option selected  value="0">Seleccione su consulta</option>
					<option value="1">Consultar por cedula</option>
					<option value="2">Consultar por nombre</option>
					<option value="3">Consultar por correo</option>
					<option value="4">Consultar por usuario</option>
				</select>
				<input type="text" name="consulta" id="consulta" placeholder="Ingrese el dato a buscar"/>
				<input type="submit" name="buscar" id="buscar" value="Buscar" />
			</section>
		</section>	
	</main>
</body>
</html>