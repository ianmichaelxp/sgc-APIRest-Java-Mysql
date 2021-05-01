package br.com.ian.sgc.sevice;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ian.sgc.model.Contato;
import br.com.ian.sgc.repository.ContatoRepository;

@Service
public class ContatoService {

	@Autowired
	private ContatoRepository contatoRepository;
	
	public List<Contato> listarContatos() {		
		List<Contato> contatos = contatoRepository.findAll();
		return contatos;
	}

	public Contato obterProcessoPorId(Long id) {
		Optional<Contato> contato = contatoRepository.findById(id);
		if(!contato.isPresent()) {
			throw new RuntimeException("Não foi possível localizar, Processo não encontrado.");
		}		
		return contato.get();
	}
}
