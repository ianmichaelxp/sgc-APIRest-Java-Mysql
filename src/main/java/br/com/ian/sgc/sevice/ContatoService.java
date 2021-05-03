package br.com.ian.sgc.sevice;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ian.sgc.controller.dto.ContatoDTO;
import br.com.ian.sgc.model.Contato;
import br.com.ian.sgc.repository.ContatoRepository;
import br.com.ian.sgc.repository.TelefoneRepository;

@Service
public class ContatoService {

	@Autowired
	private ContatoRepository contatoRepository;
	
	@Autowired
	private TelefoneRepository telefoneRepository;
	
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
		return new ContatoDTO(contato);
	}
	
	public ContatoDTO editarContato(@Valid Long id, ContatoDTO contatoDTO) {
		Optional<Contato> contato = contatoRepository.findById(id);
		if (!contato.isPresent()) {
			throw new RuntimeException("Não foi possível editar, contato não encontrado.");
		}
		
		Contato c = contato.get();
		telefoneRepository.deleteByContato(c);
		c.setPrimeiroNome(contatoDTO.getPrimeiro_nome());
		c.setUltimoNome(contatoDTO.getUltimo_nome());
		c.setEmail(contatoDTO.getEmail());
		c.setTelefones(contatoDTO.getTelefones());

		return new ContatoDTO(c);
	}
	
	public void excluirContato(Long id) {
		Optional<Contato> optional = contatoRepository.findById(id);
		if (!optional.isPresent())
			throw new RuntimeException("Não foi possível excluir, contato não encontrado.");
		contatoRepository.deleteById(id);
	}	
}
