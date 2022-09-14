package br.com.arruda.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.arruda.domain.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
