package br.com.vitor.services;

import br.com.vitor.dao.PessoaDao;
import br.com.vitor.model.Pessoa;

public class PessoaService {

	public boolean isExiste(Pessoa p) {
		PessoaDao dao = new PessoaDao();
		for (Pessoa p1 : dao.listar()) {
			if (p1.getnome().equalsIgnoreCase(p.getnome())) {
				return true;
			}
		}
		return false;
	}
}