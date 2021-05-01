package br.com.ian.sgc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ian.sgc.model.Contato;

public interface ContatoRepository extends JpaRepository<Contato, Long>{

}
