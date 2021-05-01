package br.com.ian.sgc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ian.sgc.model.Contato;
import br.com.ian.sgc.repository.ContatoRepository;

@RestController
@RequestMapping("/api/contatos")
public class ContatoController {
	
	@Autowired
	private ContatoRepository contatoRepository;

	@GetMapping
	public List<Contato> obterListaContatos(){
		List<Contato> contatos = contatoRepository.findAll();
		return contatos;
	}
}
