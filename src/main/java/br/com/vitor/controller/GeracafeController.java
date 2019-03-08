package br.com.vitor.controller;

import java.time.LocalDate;
import java.util.List;

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
	LogCafeDao LogDao;

	@Get("/geracafe")
	public void geracafe() {
		LogDao = new LogCafeDao();
		if (LogDao.listar() != null) {
			result.include("ultimos", LogDao.listar());
		}
	}

	@Get("/gerar")
	public Pessoa gerar() {
		LogDao = new LogCafeDao();
		Pessoa p = gs.selecaoAleatoria();
		if (p != null) {
			if (!gs.JaFoiEscolhido(LocalDate.now())) {
				LogDao.salvar(new UltimoEscolhidoCafe(p.getId(), p.getnome(), LocalDate.now()));
				p.setnome("Cafeteiro do dia: " + p.getnome());
				result.use(Results.json()).withoutRoot().from(p).serialize();
				return p;
			} else {
				p = new Pessoa("Hoje já foi feita a escolha, não adianta trapacear hehe");
				result.use(Results.json()).withoutRoot().from(p).serialize();
				return p;
			}
		} else {
			p = new Pessoa("Nenhuma Pessoa Cadastrada");
			result.use(Results.json()).withoutRoot().from(p).serialize();
			return p;
		}
	}

	@Get("/listar")
	public UltimoEscolhidoCafe listar() {
		LogDao = new LogCafeDao();
		List<UltimoEscolhidoCafe> u = LogDao.listar();
		if (!u.isEmpty()) {
			result.use(Results.json()).from(u.get(0)).serialize();
		}
		return u.get(0);
	}
}