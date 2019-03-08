package br.com.vitor.model;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQueries({
		@NamedQuery(name = "UltimoEscolhidoCafe.ultimos", query = "SELECT ultimos FROM UltimoEscolhidoCafe ultimos") })
public class UltimoEscolhidoCafe {

	public UltimoEscolhidoCafe() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UltimoEscolhidoCafe(Integer id, Integer idUser, String nome, Date data) {
		super();
		this.id = id;
		this.idUser = idUser;
		this.nome = nome;
	}

	public UltimoEscolhidoCafe(Integer idUser, String nome, LocalDate data) {
		super();
		this.data = Date.from(data.atStartOfDay(ZoneId.systemDefault()).toInstant());
		this.idUser = idUser;
		this.nome = nome;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer id;

	Integer idUser;

	String nome;

	@Temporal(TemporalType.DATE)
	Date data;

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

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getDataCadastroFormatado() {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		return formato.format(getData());
	}

}
