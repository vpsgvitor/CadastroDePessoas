<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<link rel="stylesheet" type="text/css" href="../css/Style.css">
<meta charset="ISO-8859-1">
<title>Editar Pessoa</title>
</head>
<header>
	<div>
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
			<div class="navbar-nav">
				<a class="nav-link opcoes text-white h5" href="../vitor/">Pessoas</a>
				<a class="nav-link opcoes text-white h5" href="../../vitor/geracafe">Cafeteiro</a>
			</div>
			<h1 class="centraliza-h1 text-white">Who will make the coffee?</h1>

		</nav>
	</div>
</header>
<body>
	<div class="centraliza tela-editar">
		<h1>Editar Pessoa</h1>
		<form action="../editar" method="post" id="editar">
			<div class="form-group row">
				<label for="ID" class="col-sm-2 col-form-label">ID</label>
				<div class="col-sm-10">
					<input name="id" readonly class="form-control-plaintext"
						value="${pessoa.id}">
				</div>
			</div>
			<div class="form-group row">
				<label for="Nome" class="col-sm-2 col-form-label">Nome</label>
				<div class="col-sm-10">
					<input type="text" name="nome" class="form-control"
						placeholder="Nome" required value="${pessoa.nome}">
				</div>
			</div>
		</form>
		<br>
		<button onClick="window.location.href='../../vitor/${pessoa.id}'"
			class="btn btn-danger">Excluir</button>
		<button onClick="window.location.href='../../vitor/';"
			class="btn btn-dark">Voltar</button>
		<button type="submit" onclick="$('#editar').submit()"
			class="btn btn-secundary">Salvar</button>
	</div>

</body>
</html>