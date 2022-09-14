package br.com.arruda.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.arruda.domain.model.Item;
import br.com.arruda.domain.model.Produto;
import br.com.arruda.domain.model.Venda;
import br.com.arruda.domain.repository.ItemRepository;
import br.com.arruda.domain.repository.VendaRepository;

@Service
public class VendaService {

	@Autowired
	private VendaRepository repository;
	
	@Autowired
	private ItemRepository itemRepository;
	
	
	public void cadastraVenda(Venda venda) {
		double valorTotal = 0.00;
		for (Item item : venda.getItens()) {
			valorTotal += item.getTotal();
		}
		venda.setValorTotal(valorTotal);
		repository.save(venda);
	}
	
	public List<Venda> consultaUltimasCincoVendasDoCliente(Long cpf) {
		List<Venda> vendas = repository.findByVendaClienteCpf(cpf);
		if(vendas.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.OK, 
					String.format("Nenhuma venda foi feita para o CPF %s", cpf));
			
		}
		return vendas;
	}
	
	/**
	 * Depois de concluir a venda, consulta o produto mais vendido na região
	 * @param venda
	 * @return
	 */
	public void consultaProdutoMaisVendidoNaRegiao(Venda venda){
//		itemRepository.produtoMaisVendidoNaRegiao(venda.getCliente().getLocalidade());
	}
	
	public List<Venda> consultaTudo() {
		return repository.findAll();
	}

}
