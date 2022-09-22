package br.com.arruda.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.arruda.domain.model.Cliente;
import br.com.arruda.domain.model.Item;
import br.com.arruda.domain.model.Produto;
import br.com.arruda.domain.model.Venda;
import br.com.arruda.domain.repository.ItemRepository;
import br.com.arruda.domain.repository.ProdutoRepository;
import br.com.arruda.domain.repository.VendaRepository;

@Service
public class VendaService {

	private static final Logger log = LoggerFactory.getLogger(VendaService.class);

	@Autowired
	private VendaRepository repository;
	
	@Autowired
	private ItemRepository itemRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private ClienteService clienteService;
	
	
	public void cadastraVenda(Venda venda) {
		log.info("cadastraVenda()");
		double valorTotal = 0.00;
		for (Item item : venda.getItens()) {
			adicionaItem(item);
			valorTotal += item.getTotal();
		}
		venda.setValorTotal(valorTotal);
		repository.save(venda);
	}
	
	public void adicionaItem(Item item) {
		Optional<Produto> produto = produtoRepository.findById(item.getProduto().getCodigo());
		if(!produto.isPresent()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, 
					String.format("Código do produto %s é inválido", item.getProduto().getCodigo()));
		}
		item.setValorUnitario(produto.get().getPreco());
		item.setProduto(produto.get());
	}
	
	public List<Venda> consultaUltimasCincoVendasDoCliente(Long cpf) {
		List<Venda> vendas = repository.findByVendaClienteCpf(cpf);
		if(vendas.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.OK, 
					String.format("Nenhuma venda foi feita para o cliente com CPF %s", cpf));
			
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
	
	/**
	 * Exibe itens por municipio
	 * @param venda
	 * @return
	 */
	public List<Item> consultaVendaPorCidade(Long cpf) {
		Optional<Cliente> cliente = clienteService.findByCPF(cpf);
		return itemRepository.findByItemByMunicipio(cliente.get().getLocalidade());
	}
	
	public List<Venda> consultaTudo() {
		return repository.findAll();
	}

}
