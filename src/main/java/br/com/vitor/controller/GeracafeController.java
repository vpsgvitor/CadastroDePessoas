package br.com.vitor.controller;

import java.time.LocalDate;

import javax.inject.Inject;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import br.com.vitor.dao.LogCafeDao;
import br.com.vitor.model.UltimoEscolhidoCafe;
import br.com.vitor.model.Pessoa;
import br.com.vitor.services.GeracafeService;

@Resource
public class GeracafeController {
	@Inject
	Result result;
	GeracafeService gs = new GeracafeService();
	LogCafeDao LogDao = new LogCafeDao();

	@Get("/geracafe")
	public void geracafe() {
		if (LogDao.listar() != null) {
			result.include("ultimos", LogDao.listar());
		}
	}

	@Get("/gerar")
	public Pessoa gerar() {
		Pessoa p = null;
		if (!gs.JaFoiEscolhido(LocalDate.now())) {
			p = gs.selecaoAleatoria();
			LogDao.salvar(new UltimoEscolhidoCafe(p.getId(), p.getnome(), LocalDate.now()));
			result.use(Results.json()).withoutRoot().from(p).serialize();
			return p;
		} else {
			p = new Pessoa("Hoje já foi feita a escolha, não adianta trapacear hehe");
			result.use(Results.json()).withoutRoot().from(p).serialize();
			return p;
		}
	}
}