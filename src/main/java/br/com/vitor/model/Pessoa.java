package br.com.vitor.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({ @NamedQuery(name = "Pessoa.listar", query = "SELECT pessoa FROM Pessoa pessoa"),
		@NamedQuery(name = "Pessoa.buscarPorId", query = "SELECT pessoa FROM Pessoa pessoa where id = :id") })
public class Pessoa implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Integer id;

	private String nome;

	public Pessoa() {
		super();
	}

	public Pessoa(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	public Pessoa(String nome) {
		super();
		this.nome = nome;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getnome() {
		return nome;
	}

	public void setnome(String nome) {
		this.nome = nome;
	}
}