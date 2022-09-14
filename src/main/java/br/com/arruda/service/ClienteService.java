package br.com.arruda.service;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.arruda.domain.model.Cliente;
import br.com.arruda.domain.repository.ClienteRepository;

@Service
public class ClienteService implements Serializable {

	private static final long serialVersionUID = 61521507070171429L;
	
	@Autowired
	private ClienteRepository repository;
	
	public Optional<Cliente> findByCPF(Long cpf) {
		Optional<Cliente> cliente = repository.findById(cpf);
		if(cliente.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.OK, 
					String.format("Nenhum cliente encontrado com o CPF %s", cpf));
		}
		return cliente;
	}

}
