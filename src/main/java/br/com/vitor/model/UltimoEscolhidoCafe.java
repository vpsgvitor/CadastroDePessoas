package br.com.vitor.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
		@NamedQuery(name = "UltimoEscolhidoCafe.ultimos", query = "SELECT ultimos FROM UltimoEscolhidoCafe ultimos") })
public class UltimoEscolhidoCafe {

	public UltimoEscolhidoCafe() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UltimoEscolhidoCafe(Integer id, Integer idUser, String nome) {
		super();
		this.id = id;
		this.idUser = idUser;
		this.nome = nome;
	}

	public UltimoEscolhidoCafe(Integer idUser, String nome) {
		super();
		this.idUser = idUser;
		this.nome = nome;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer id;

	Integer idUser;

	String nome;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

}
