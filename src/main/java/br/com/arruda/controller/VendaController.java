package br.com.arruda.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.arruda.domain.model.Item;
import br.com.arruda.domain.model.Venda;
import br.com.arruda.service.VendaService;

@RestController
@RequestMapping("/api/venda")
public class VendaController {
	
	@Autowired
	private VendaService vendaService;
	
	@PostMapping
	public ResponseEntity<List<Item>> cadastrar(@Valid @RequestBody Venda venda) {
		vendaService.cadastraVenda(venda);
		List<Item> itensMaisCompradosDaRegiao = vendaService.consultaVendaPorCidade(venda.getCliente().getCpf());
		return ResponseEntity.status(HttpStatus.OK).body(itensMaisCompradosDaRegiao);
	}
	
	@GetMapping("/{cpf}")
	public ResponseEntity<List<Venda>> consultarAsUltimasComprasDoCliente(@PathVariable Long cpf) {
		List<Venda> vendas = vendaService.consultaUltimasCincoVendasDoCliente(cpf);
		return ResponseEntity.status(HttpStatus.OK).body(vendas);
	}
	
	@GetMapping
	public ResponseEntity<List<Venda>> consultarTudo() {
		List<Venda> vendas = vendaService.consultaTudo();
		return ResponseEntity.status(HttpStatus.OK).body(vendas);
	}
}
