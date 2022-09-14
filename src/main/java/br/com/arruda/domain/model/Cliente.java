package br.com.arruda.domain.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Cliente implements Serializable {

	private static final long serialVersionUID = 3525763089109471472L;
	
	@Id
	private Long cpf;
	
	@NotBlank
	private String nome;
	
	@ManyToOne
	@JoinColumn(name = "localidade")
	private Municipio localidade;

}
