package br.com.ian.sgc.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.ian.sgc.model.Contato;

public interface ContatoRepository extends JpaRepository<Contato, Long>{

	@Query("SELECT c FROM Contato c WHERE c.primeiroNome = :primeiroNome or c.email = :email")
	Page<Contato> findByPrimeiroNomeOrEmailContaining(String primeiroNome, String email, Pageable paginacao);
}
