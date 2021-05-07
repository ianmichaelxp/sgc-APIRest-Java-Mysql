package br.com.ian.sgc.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Contato {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="primeiro_nome", nullable = false)
	private String primeiroNome;
	
	@Column(name="ultimo_nome", nullable = false)
	private String ultimoNome;
	
	@Column(nullable = false)
	private String email;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "contato")
	@JsonManagedReference
	private List<Telefone> telefones = new ArrayList<Telefone>();
	
	public Contato() {}
	
	public Contato(String primeiroNome, String ultimoNome, String email, List<Telefone> telefones) {
		this.primeiroNome = primeiroNome;
		this.ultimoNome = ultimoNome;
		this.email = email;
		this.telefones = telefones;
		this.adicionarTelefones();

	}	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPrimeiroNome() {
		return primeiroNome;
	}

	public void setPrimeiroNome(String primeiroNome) {
		this.primeiroNome = primeiroNome;
	}

	public String getUltimoNome() {
		return ultimoNome;
	}

	public void setUltimoNome(String ultimoNome) {
		this.ultimoNome = ultimoNome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	private void adicionarTelefones() {
		telefones.forEach(telefone -> {
			telefone.setContato(this);
		});
	}
	public List<Telefone> getTelefones() {
		return telefones;
	}
	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
		adicionarTelefones();
	}
}