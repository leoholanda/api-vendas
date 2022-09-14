package br.com.arruda.domain.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Item implements Serializable {

	private static final long serialVersionUID = -8161709525665356383L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "produto")
	private Produto produto;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "venda")
	@JsonBackReference
	private Venda venda;

	@Column(name = "valor_unitario")
	private Double valorUnitario;

	@Column(name = "quantidade")
	private Integer quantidade;
	
	@PrePersist
	public void create() {
		valorUnitario = produto.getPreco();
	}

	public Double getTotal() {
		return quantidade != null && valorUnitario != null ? quantidade * valorUnitario : 0;
	}
}
