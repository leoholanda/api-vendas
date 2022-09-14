package br.com.arruda.domain.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "codigo")
@Entity
public class Produto implements Serializable {

	private static final long serialVersionUID = -7719079964355788153L;
	
	@Id
	@GeneratedValue
	private Long codigo;
	
	@NotBlank
	private String nome;
	
	private String descricao;
	
	@NotNull
	private Double preco;

}
