package br.com.ian.sgc.controller.dto;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.domain.Page;

import br.com.ian.sgc.model.Contato;
import br.com.ian.sgc.model.Telefone;

public class ContatoDTO {
	
	private Long id;
	
	@NotNull
    @Size(max = 120)
	private String primeiroNome;
	
	@NotNull
    @Size(max = 120)
	private String ultimoNome;
	
	@Email(message="E-mail inválido")
	@NotNull
	private String email;
	
	@NotEmpty
	private List<Telefone> telefones;
	
	public ContatoDTO() {}

	public ContatoDTO(Contato contato) {
		this.id = contato.getId();
		this.primeiroNome = contato.getPrimeiroNome();
		this.ultimoNome = contato.getUltimoNome();
		this.email = contato.getEmail();
		this.telefones = contato.getTelefones();		
	}

	public static Page<ContatoDTO> contatoToDTO(Page<Contato> contatos) {
		Page<ContatoDTO> contatosDTOs = contatos.map(contato -> {
			return new ContatoDTO(contato);
		});
		return contatosDTOs;
	}
	
	public static Contato contatoToEntity(@Valid ContatoDTO dto) {
		Contato contato = new Contato(dto.getPrimeiroNome(), dto.getUltimoNome(),dto.getEmail(), dto.getTelefones());
		return contato;
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

	public List<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}
}
