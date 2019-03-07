package br.com.vitor.services;

import java.util.Collections;
import java.util.List;

import br.com.vitor.dao.PessoaDao;
import br.com.vitor.model.Pessoa;

public class GeracafeService {

	PessoaDao dao = new PessoaDao();

	public Pessoa selecaoAleatoria() {
		List<Pessoa> pessoas = dao.listar();
		Collections.shuffle(pessoas);
		return pessoas.get(0);
	}

}