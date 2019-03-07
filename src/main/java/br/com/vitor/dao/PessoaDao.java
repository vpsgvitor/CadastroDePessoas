package br.com.vitor.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.vitor.model.Pessoa;
import hibernateUtil.HibernateUtil;

public class PessoaDao {
	Session session;

	@SuppressWarnings("unchecked")
	public List<Pessoa> listar() {
		session = HibernateUtil.getSessionFactory().openSession();
		List<Pessoa> pessoas = null;
		Query consulta = session.getNamedQuery("Pessoa.listar");
		pessoas = consulta.list();
		session.close();
		return pessoas;
	}

	public Pessoa buscarPorId(Integer id) {
		session = HibernateUtil.getSessionFactory().openSession();
		Pessoa pessoa = new Pessoa();
		Query consulta = session.getNamedQuery("Pessoa.buscarPorId");
		consulta.setInteger("id", id);
		pessoa = (Pessoa) consulta.uniqueResult();
		session.close();
		return pessoa;
	}

	public void salvar(Pessoa p) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		try {
			transacao = session.beginTransaction();
			session.save(p);
			transacao.commit();
		} catch (Exception e) {
			if (transacao != null) {
				transacao.rollback();
			}
		} finally {
			session.close();
		}
	}

	public void alterar(Pessoa p) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		try {
			transacao = session.beginTransaction();
			session.update(p);
			transacao.commit();
		} catch (Exception e) {
			if (transacao != null) {
				transacao.rollback();
			}
		} finally {
			session.close();
		}
	}

	public void deletar(Pessoa p) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		try {
			transacao = session.beginTransaction();
			session.delete(p);
			transacao.commit();
		} catch (Exception e) {
			if (transacao != null) {
				transacao.rollback();
			}
		} finally {
			session.close();
		}
	}
}