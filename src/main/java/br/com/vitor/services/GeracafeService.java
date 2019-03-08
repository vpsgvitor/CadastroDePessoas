package br.com.vitor.services;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import br.com.vitor.dao.LogCafeDao;
import br.com.vitor.dao.PessoaDao;
import br.com.vitor.model.Pessoa;

public class GeracafeService {

	PessoaDao dao = new PessoaDao();
	LogCafeDao cdao = new LogCafeDao();

	public Pessoa selecaoAleatoria() {
		List<Pessoa> pessoas = dao.listar();
		if (!pessoas.isEmpty()) {
			Collections.shuffle(pessoas);
			return pessoas.get(0);
		} else {
			return null;
		}
	}

	public boolean JaFoiEscolhido(LocalDate data) {
		Date dt = Date.from(data.atStartOfDay(ZoneId.systemDefault()).toInstant());
		dt.setDate(dt.getDate() + 1);
		if (cdao.listar().size() > 0 && cdao.listar() != null) {
			if (dt.compareTo((cdao.listar().get(0).getData())) >= 0) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
}