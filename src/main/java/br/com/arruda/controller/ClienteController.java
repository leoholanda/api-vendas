package br.com.arruda.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.arruda.domain.model.Cliente;
import br.com.arruda.service.ClienteService;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping("/{cpf}")
	public ResponseEntity<Cliente> consultaClientePorCpf(@PathVariable Long cpf) {
		Optional<Cliente> cliente = clienteService.findByCPF(cpf);
		return ResponseEntity.status(HttpStatus.OK).body(cliente.get());
	}

}
