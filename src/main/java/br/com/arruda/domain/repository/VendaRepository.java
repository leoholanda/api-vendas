package br.com.arruda.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.arruda.domain.model.Cliente;
import br.com.arruda.domain.model.Venda;

public interface VendaRepository extends JpaRepository<Venda, Long> {
	
	@Query("SELECT v FROM Venda v WHERE v.cliente = :cliente ORDER BY v.dataVenda DESC")
	List<Venda> findByClientLastFiveSale(Cliente cliente);
	
	@Query("SELECT v FROM Venda v WHERE v.cliente.cpf = :cpf ORDER BY v.dataVenda DESC")
	List<Venda> findByVendaClienteCpf(Long cpf);

}
