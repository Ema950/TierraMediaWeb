<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/login.css">
</head>
<style>
body {
	background: url(img/Inicio.jpg) center fixed no-repeat
}
</style>
<body background="img/Inicio.jpg">
	<div>
		<main>
			<h1>Bienvenido</h1>
			<c:if test="${flash != null}">
				<div>
					<p>
						<c:out value="${flash}" />
					</p>
				</div>
			</c:if>
			
			<c:if test="${success != null}">
				<div>
					<p>
						<c:out value="${success}" />
					</p>
				</div>
			</c:if>

			<form action="login" method="post">

				<div class="mb-3">
					<label for="username" class="form-label">Usuario</label> <input
						class="form-control" name="username">
				</div>

				<div class="mb-3">
					<label for="password" class="form-label">Contraseña</label> <input
						type="password" class="form-control" name="password">
				</div>

				<div>
					<button type="submit">Ingresar</button>
				</div>
			</form>

		</main>
	</div>
</body>
</html>