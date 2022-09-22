package br.com.arruda.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.arruda.domain.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
