package br.com.arruda.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.arruda.domain.model.Item;
import br.com.arruda.domain.model.Municipio;

public interface ItemRepository extends JpaRepository<Item, Long> {
	
//	@Query("SELECT i FROM Item i "
//			+ "WHERE i.venda.cliente.municipio = :municipio")
//	List<Item> produtoMaisVendidoNaRegiao(Municipio municipio); 
	
//	@Query("SELECT sum(i.quantidade) FROM Item i "
//			+ "WHERE i.venda.cliente.municipio = :municipio "
//			+ "AND i.produto = (select max(i2.produto) FROM Item i2)")
//	Long quantidadeDeprodutoMaisVendidoNaRegiao(Municipio municipio); 

}
