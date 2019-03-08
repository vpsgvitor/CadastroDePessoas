function sortear() {
	let div1 = $('<div>');
	let div2 = $('<div>');
	let h1 = $('<h1>')
	div1.addClass("jumbotron jumbotron-fluid");
	div2.addClass("container");
	h1.addClass("display-4");
	$.get("gerar", function(pessoa) {
		h1.html(pessoa.nome);
	})
	div2.append(h1);
	div1.append(div2);
	$('#Meu').append(div1)
}