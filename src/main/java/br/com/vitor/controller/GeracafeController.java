package br.com.vitor.controller;

import com.google.inject.Inject;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
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
		Pessoa p = gs.selecaoAleatoria();
		result.include("pessoa", p);
		LogDao.salvar(new UltimoEscolhidoCafe(p.getId(), p.getnome()));
		result.include("ultimos", LogDao.listar());
	}
}