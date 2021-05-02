package br.com.ian.sgc.sevice;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import br.com.ian.sgc.controller.dto.ContatoDTO;
import br.com.ian.sgc.model.Contato;
import br.com.ian.sgc.repository.ContatoRepository;

@Service
public class ContatoService {

	@Autowired
	private ContatoRepository contatoRepository;
	
	public List<ContatoDTO> listarContatos() {		
		List<Contato> contatos = contatoRepository.findAll();
		return ContatoDTO.contatoToDTO(contatos);
	}

	public Contato obterProcessoPorId(Long id) {
		Optional<Contato> contato = contatoRepository.findById(id);
		if(!contato.isPresent()) {
			throw new RuntimeException("Não foi possível localizar, contato não encontrado.");
		}		
		return contato.get();
	}
	
	public ContatoDTO salvarContato(@Valid ContatoDTO contatoDTO) {
		Contato contato = ContatoDTO.contatoToEntity(contatoDTO);
		contatoRepository.save(contato);
		return contatoDTO;
	}
	
	
	
	
}
