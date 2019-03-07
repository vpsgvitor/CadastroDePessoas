package br.com.vitor.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.vitor.dao.PessoaDao;
import br.com.vitor.model.Pessoa;
import br.com.vitor.services.PessoaService;

@Resource
public class EditarController {
	boolean v;
	@Inject
	Result result;
	PessoaDao dao = new PessoaDao();
	PessoaService ps = new PessoaService();

	@Get("/editar/{id}")
	public void editar(Integer id) {
		result.include("pessoa", dao.buscarPorId(id));
	}

	@Post("/editar")
	public void index(Integer id, String nome) throws Exception {
		if (!nome.isEmpty() && !ps.isExiste(new Pessoa(id, nome))) {
			dao.alterar(new Pessoa(id, nome));
		} else {
			result.include("alerta", "Já existe alguém com este nome ou o campo esta vazio!");
		}
		result.redirectTo(IndexController.class).index();
	}
}