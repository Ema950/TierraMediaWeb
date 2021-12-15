<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/Sugerencias.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
body {
	background: url(img/Inicio.jpg) center fixed no-repeat
}
</style>
<body background="img/Inicio.jpg">
 <h1><%= (String) request.getAttribute("h1") %> </h1> <br>
 <div class = "descripcion"><%= (String) request.getAttribute("descripcion") %></div><br>
 <div class = atracciones>Se sugieren las siguientes atracciones<br> 
 <%= request.getAttribute("lista") %>
 
 	<table class="tabla">
			<thead>
				<tr>
					<th>Atracci&oacute;n</th>
					<th>Costo</th>
					<th>Duraci&oacute;n</th>
					<th>Cupo</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${lista}" var="lista">
					<tr>
						<td><strong><c:out value="${lista.nombre}"></c:out></strong></td>
						<td><c:out value="${lista.costo}"></c:out></td>
						<td><c:out value="${lista.duracion}"></c:out></td>
						<td><c:out value="${lista.cupo}"></c:out></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
 	
 	
 </div><br>
</body> 
</html>