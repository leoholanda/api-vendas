package br.com.arruda.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.arruda.domain.model.Municipio;

@Repository
public interface MunicipioRepository extends JpaRepository<Municipio, Long> {
	
	List<Municipio> findByUnidadeFederacao(String unidadeFederacao);

}
