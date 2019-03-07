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
public class IndexController {

	@Inject
	Result result;
	PessoaDao dao = new PessoaDao();
	PessoaService ps = new PessoaService();

	@Get("/")
	public void index() throws Exception {
		result.include("pessoas", dao.listar());
	}

	@Post("/")
	public void cadastrar(String nome) throws Exception {
		if (!ps.isExiste(new Pessoa(nome)) && !nome.isEmpty()) {
			dao.salvar(new Pessoa(nome));
		} else {
			result.include("alerta", "Já existe alguém com este nome!");
		}
		result.forwardTo(IndexController.class).index();
	}

	@Get("/{id}")
	public void excluir(Integer id) throws Exception {
		dao.deletar(dao.buscarPorId(id));
		result.forwardTo(IndexController.class).index();
	}
}