package br.com.arruda.domain.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.arruda.domain.enums.UF;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Municipio implements Serializable {

	private static final long serialVersionUID = 6638561004630472721L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	private Long id;
	
	@NotBlank
	private String nome;
	
	@Enumerated(value = EnumType.STRING)
	@JoinColumn(name = "unidade_federacao")
	private UF unidadeFederacao;

}
