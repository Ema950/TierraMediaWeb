<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <h1><%= (String) request.getAttribute("h1") %> </h1> <br>
 <div><%= (String) request.getAttribute("descripcion") %></div><br>
 <div>Se sugieren las siguientes atracciones<br> 
 <%= request.getAttribute("Lista").toString() %></div>

</body> 
</html>