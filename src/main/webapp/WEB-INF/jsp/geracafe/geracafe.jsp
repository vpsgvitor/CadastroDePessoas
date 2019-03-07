<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="shortcut icon" href="favicon.ico" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/Style.css">
<meta charset="ISO-8859-1">
<title>Quem fará o café?</title>
</head>
<body class="centraliza">
	<h1>ID = ${pessoa.id} and Nome= ${pessoa.nome}</h1>

	<div>
		<table class="table table-striped table-hover">
			<thead class="thead-dark">
				<tr>
					<th scope="row">ID</th>
					<th scope="row">Nome</th>
				</tr>
			</thead>
			<c:forEach var="ultimo" items="${ultimos}">
				<tr>
					<td>${ultimo.idUser}</td>
					<td>${ultimo.nome}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>