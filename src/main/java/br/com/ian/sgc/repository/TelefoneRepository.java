package br.com.ian.sgc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ian.sgc.model.Contato;
import br.com.ian.sgc.model.Telefone;

public interface TelefoneRepository extends JpaRepository<Telefone, Long> {

	long deleteByContato(Contato contato);
}
