package br.com.ian.sgc.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import br.com.ian.sgc.model.Contato;
import br.com.ian.sgc.model.Telefone;

public class ContatoDTO {
	
	private Long id;
	private String primeiro_nome;
	private String ultimo_nome;
	private String email;
	private List<Telefone> telefones;
	
	public ContatoDTO() {}
	
	public ContatoDTO(Contato contato) {
		this.id = contato.getId();
		this.primeiro_nome = contato.getPrimeiroNome();
		this.ultimo_nome = contato.getUltimoNome();
		this.email = contato.getEmail();
		this.telefones = contato.getTelefones();		
	}

	public static List<ContatoDTO> contatoToDTO(List<Contato> contatos) {
		List<ContatoDTO> contatosDTOs = contatos.stream().map(contato -> {
			return new ContatoDTO(contato);
		}).collect(Collectors.toList());
		return contatosDTOs;
	}
	
	public static Contato contatoToEntity(@Valid ContatoDTO dto) {
		Contato contato = new Contato(dto.getPrimeiro_nome(), dto.getUltimo_nome(),dto.getEmail(), dto.getTelefones());
		return contato;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPrimeiro_nome() {
		return primeiro_nome;
	}
	public void setPrimeiro_nome(String primeiro_nome) {
		this.primeiro_nome = primeiro_nome;
	}
	public String getUltimo_nome() {
		return ultimo_nome;
	}
	public void setUltimo_nome(String ultimo_nome) {
		this.ultimo_nome = ultimo_nome;
	}

	public List<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}
}
