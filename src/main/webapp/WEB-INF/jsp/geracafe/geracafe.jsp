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
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
<script src="http://code.jquery.com/ui/1.9.2/jquery-ui.js"></script>
<link rel="stylesheet" type="text/css" href="css/Style.css">
<script src="js/script.js"></script>
<meta charset="ISO-8859-1">
<title>Quem fará o café?</title>
</head>
<body class="centraliza" onLoad="adicionarNaTabela()">
	<h1>Sortear o cafeteiro</h1>
	<hr>
	<div id="Meu"></div>
	<button type="submit" onclick="sortear();"
		class="btn-sorteio btn btn-dark">Clique aqui para sortear um
		cafeteiro</button>
	<div>
		<table class="table table-striped table-hover tabela-ultimos">
			<thead class="thead-dark">
				<tr>
					<th scope="row">ID</th>
					<th scope="row">Nome</th>
					<th scope="row">Data</th>
				</tr>
			</thead>
			<tbody id="tbodyTabelaUltimos"></tbody>
		</table>
	</div>
</body>
</html>