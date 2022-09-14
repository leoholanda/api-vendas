package br.com.arruda.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.arruda.domain.model.Municipio;
import br.com.arruda.domain.repository.MunicipioRepository;

public class MunicipioService implements Serializable {

	private static final long serialVersionUID = -5840493212879747828L;
	
	@Autowired
	private MunicipioRepository repository;
	
	public List<Municipio> listaMunicipioPorUf(String uf) {
		return repository.findByUnidadeFederacao(uf);
	}

}
