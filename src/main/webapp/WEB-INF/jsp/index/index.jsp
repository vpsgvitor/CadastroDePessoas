<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/Style.css">
<link rel="shortcut icon" href="favicon.ico" />
<meta charset="ISO-8859-1">
<title>.:Café:.</title>
</head>
<body class="centraliza">
	<c:if test="${alerta != null}">
		<div class="alert alert-warning alert-dismissible fade show"
			role="alert">
			<strong>Errou!!</strong> ${alerta}
		</div>
	</c:if>
	<br>
	<h1 class="centraliza">Who will make the coffee?</h1>
	<div class="div-cafe">
		<button class="btn btn-dark btn-cafe" type="submit"
			onClick="window.location.href='../vitor/geracafe';">Escolher
			quem vai fazer o cafe!</button>
	</div>
	<hr>
	<form action="../vitor/" method="post">
		<div class="input-group mb-3">
			<input type="text" class="form-control" required
				placeholder="Adicionar nova pessoa" aria-describedby="basic-addon2"
				name="nome">
			<div class="input-group-append">
				<button class="btn btn-outline-secondary btn-dark" type="submit">Adicionar</button>
			</div>
		</div>
	</form>
	<div>
		<table class="table table-striped table-hover">
			<thead class="thead-dark">
				<tr>
					<th scope="row">ID</th>
					<th scope="row">Nome <i>(Clique sobre o nome para as
							opções)</i>
					</th>
				</tr>
			</thead>
			<c:forEach var="pessoa" items="${pessoas}">
				<tr onClick="window.location.href='../vitor/editar/${pessoa.id}';">
					<td>${pessoa.id}</td>
					<td>${pessoa.nome}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>