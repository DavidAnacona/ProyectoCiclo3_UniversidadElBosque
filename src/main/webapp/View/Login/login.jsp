<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta charset="UTF-8">
	<title>Tienda generica</title>
	<link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Krub:wght@400;700&display=swap" rel="stylesheet">
	<link rel="stylesheet" href="style.css">
</head>
<body>
	<main>
		<form action="" class="main--formulario-login"> 
			<p class="formulario--login-titulo">Iniciar sesi&oacuten</p>
			<label for="usuario" class="formulario--login-label">
				<span>Usuario </span>
				<input class="formulario--login-campos" id="usuario" type="text" placeholder="Ingresa tu usuario" />
			</label>
			
			<label for="password" class="formulario--login-label">
				<span>Password </span>
				<input class="formulario--login-campos" id="password" type="password" placeholder="Ingresa tu contraseña"/>
			</label>
			<input class="formulario--login-submit" type="submit" value="Ingresar" />
		</form>
	</main>
	
	<footer>
		<p>Todos los derechos reservados Grupo 1.1 Universidad El Bosque</p>
	</footer>
</body>
</html>