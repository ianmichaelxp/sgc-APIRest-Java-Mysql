package br.com.ian.sgc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ian.sgc.model.Contato;
import br.com.ian.sgc.repository.ContatoRepository;
import br.com.ian.sgc.sevice.ContatoService;

@RestController
@RequestMapping("/api/contatos")
public class ContatoController {
	
	@Autowired
	private ContatoService contatoService;

	@GetMapping
	public List<Contato> obterListaContatos(){
		List<Contato> contatos = contatoService.listarContatos();
		return contatos;
	}
	
	 @GetMapping("/{id}")
		public ResponseEntity<Contato> obterContato(@PathVariable(value="id") Long id) {		
			Contato contato = contatoService.obterProcessoPorId(id);		
			return ResponseEntity.ok(contato);
		}
}
