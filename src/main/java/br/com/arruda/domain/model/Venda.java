package br.com.arruda.domain.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
public class Venda implements Serializable {

	private static final long serialVersionUID = 3509419989518620847L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@JsonIgnore
	@Column(name = "data_venda")
	private LocalDateTime dataVenda;

	@ManyToOne
	@JoinColumn(name = "cliente")
	private Cliente cliente;

	@OneToMany(mappedBy = "venda", fetch = FetchType.LAZY)
	@JsonManagedReference
	private List<Item> itens = new ArrayList<Item>();

	@Column(name = "valor_total")
	private Double valorTotal;

	@PrePersist
	public void create() {
		dataVenda = LocalDateTime.now();
	}

	public String getDataDaCompra() {
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		return dataVenda.format(dateFormatter);
	}

	@Override
	public String toString() {
		return "Venda [id=" + id + ", dataVenda=" + dataVenda + ", cliente=" + cliente + "]";
	}

}
