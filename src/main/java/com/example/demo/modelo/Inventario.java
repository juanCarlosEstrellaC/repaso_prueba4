package com.example.demo.modelo;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "inventario")
public class Inventario {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "inve_seq")
	@SequenceGenerator(name = "inve_seq", sequenceName = "inve_seq", allocationSize = 1)
	@Column(name = "inve_id")
	private Integer id;
	@Column(name = "inve_numero_bodega")
	private String numeroBodega;
	@Column(name = "inve_codigoMaestro")
	private String codigoMaestro;

	@Column(name = "inve_cantidad")
	private BigDecimal cantidad;

	@Column(name = "codigoIndividual")
	private String codigoIndividual;
	
	// RELACIONES
	@ManyToOne
	@JoinColumn(name = "inve_id_producto")
	private Producto miProducto;

	@ManyToOne
	@JoinColumn(name = "inve_id_bodega")
	private Bodega miBodega;

	// TOSTRING:
	@Override
	public String toString() {
		return "Inventario [id=" + id + ", numeroBodega=" + numeroBodega + ", codigoMaestro=" + codigoMaestro
				+ ", cantidad=" + cantidad + "]";
	}

	// GET Y SET
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumeroBodega() {
		return numeroBodega;
	}

	public void setNumeroBodega(String numeroBodega) {
		this.numeroBodega = numeroBodega;
	}

	public String getCodigoMaestro() {
		return codigoMaestro;
	}

	public void setCodigoMaestro(String codigoMaestro) {
		this.codigoMaestro = codigoMaestro;
	}

	public BigDecimal getCantidad() {
		return cantidad;
	}

	public void setCantidad(BigDecimal cantidad) {
		this.cantidad = cantidad;
	}

	public Producto getMiProducto() {
		return miProducto;
	}

	public void setMiProducto(Producto miProducto) {
		this.miProducto = miProducto;
	}

	public Bodega getMiBodega() {
		return miBodega;
	}

	public void setMiBodega(Bodega miBodega) {
		this.miBodega = miBodega;
	}

	public String getCodigoIndividual() {
		return codigoIndividual;
	}

	public void setCodigoIndividual(String codigoIndividual) {
		this.codigoIndividual = codigoIndividual;
	}

	
}
