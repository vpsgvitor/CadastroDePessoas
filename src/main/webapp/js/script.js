function sortear() {
	document.getElementById('Meu').innerHTML = "";
	let div1 = $('<div>');
	let div2 = $('<div>');
	let h1 = $('<h1>')
	div1.addClass("jumbotron jumbotron-fluid");
	div2.addClass("container");
	h1.addClass("display-5");
	$.get("gerar", function(pessoa) {
		h1.html(pessoa.nome);
	})
	div2.append(h1);
	div1.append(div2);
	$('#Meu').append(div1);

	setTimeout(function() {
		adicionarNaTabela();
	}, 500);
}
function adicionarNaTabela() {
	$.get("listar", function(retorno) {
		var pessoas = retorno;
		document.getElementById('tbodyTabelaUltimos').innerHTML = "";
		$.each(pessoas, function(i, pessoa) {
			let tr = $('<tr>');
			let tdId = $('<td>');
			let tdNome = $('<td>');
			let tdData = $('<td>');

			tdId.html(pessoa.id);
			tdNome.html(pessoa.nome);
			tdData.html(pessoa.data.$);

			tr.append(tdId);
			tr.append(tdNome);
			tr.append(tdData);
			$("#tbodyTabelaUltimos").append(tr);

		});
	})
}