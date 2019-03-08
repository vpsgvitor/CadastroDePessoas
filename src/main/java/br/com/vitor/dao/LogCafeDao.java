package br.com.vitor.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.vitor.model.UltimoEscolhidoCafe;
import br.com.vitor.model.Pessoa;
import hibernateUtil.HibernateUtil;

public class LogCafeDao {

	Session session;

	@SuppressWarnings("unchecked")
	public List<UltimoEscolhidoCafe> listar() {
		session = HibernateUtil.getSessionFactory().openSession();
		List<UltimoEscolhidoCafe> ultimos = null;
		Query consulta = session.getNamedQuery("UltimoEscolhidoCafe.ultimos");
		ultimos = consulta.list();
		if (!ultimos.isEmpty()) {
			for (UltimoEscolhidoCafe u : ultimos) {
				u.getData().setDate(u.getData().getDate() + 1);
			}
		}
		session.close();
		return ultimos;
	}

	public void salvar(UltimoEscolhidoCafe u) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		try {
			transacao = session.beginTransaction();
			session.save(u);
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
