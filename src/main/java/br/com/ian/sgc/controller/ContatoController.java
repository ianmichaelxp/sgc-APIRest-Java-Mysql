package br.com.ian.sgc.controller;

import java.net.URI;
import java.net.URISyntaxException;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.ian.sgc.controller.dto.ContatoDTO;
import br.com.ian.sgc.model.Contato;
import br.com.ian.sgc.sevice.ContatoService;

@RestController
@RequestMapping("/api/contatos")
@CrossOrigin({"*"})
public class ContatoController {

	@Autowired
	private ContatoService contatoService;

	@GetMapping
	public Page<ContatoDTO> obterListaContatos(@RequestParam(required = false) String primeiroNome, @RequestParam(required = false) String email,
			@PageableDefault(sort = "id", direction = Direction.ASC, page = 0, size = 10)Pageable paginacao) {
		Page<ContatoDTO> contatosDTOs = contatoService.listarContatos(primeiroNome, email, paginacao);
		return contatosDTOs;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Contato> obterContato(@PathVariable(value = "id") Long id) {
		Contato contato = contatoService.obterProcessoPorId(id);
		return ResponseEntity.ok(contato);
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<ContatoDTO> criarContato(@Valid @RequestBody ContatoDTO contatoDTO) throws URISyntaxException{
		ContatoDTO contato = contatoService.salvarContato(contatoDTO);
		return ResponseEntity.created(new URI("/contatos")).body(contato);
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<ContatoDTO> atualizarContato(@PathVariable Long id, @RequestBody @Valid ContatoDTO contatoDTO) {		
		ContatoDTO dto = contatoService.editarContato(id, contatoDTO);
		return ResponseEntity.ok(dto);
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> removerContato(@PathVariable Long id) {
		contatoService.excluirContato(id);	
		return ResponseEntity.ok().build();
	}
}
