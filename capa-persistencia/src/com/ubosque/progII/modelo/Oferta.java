package com.ubosque.progII.modelo;

import java.io.Serializable;
import javax.persistence.*;

import org.eclipse.persistence.annotations.ReturnInsert;



/**
 * The persistent class for the OFERTA database table.
 * 
 */
@Entity
@NamedQuery(name="Oferta.findAll", query="SELECT o FROM Oferta o")
public class Oferta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@ReturnInsert(returnOnly = true)
	@Column(name="OFERTA_ID")
	private String ofertaId;

	private Long aniosexperiencia;

	private String area;

	@Column(name="CARGO_ID")
	private Long cargoId;

	@Column(name="EMPRESA_ID")
	private Long empresaId;

	private String nivelacademico;

	private String profesion;

	private String salario;

	private String tipocontrato;

	public Oferta() {
	}

	public String getOfertaId() {
		return this.ofertaId;
	}

	public void setOfertaId(String ofertaId) {
		this.ofertaId = ofertaId;
	}

	public Long getAniosexperiencia() {
		return this.aniosexperiencia;
	}

	public void setAniosexperiencia(Long aniosexperiencia) {
		this.aniosexperiencia = aniosexperiencia;
	}

	public String getArea() {
		return this.area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public Long getCargoId() {
		return this.cargoId;
	}

	public void setCargoId(Long cargoId) {
		this.cargoId = cargoId;
	}

	public Long getEmpresaId() {
		return this.empresaId;
	}

	public void setEmpresaId(Long empresaId) {
		this.empresaId = empresaId;
	}

	public String getNivelacademico() {
		return this.nivelacademico;
	}

	public void setNivelacademico(String nivelacademico) {
		this.nivelacademico = nivelacademico;
	}

	public String getProfesion() {
		return this.profesion;
	}

	public void setProfesion(String profesion) {
		this.profesion = profesion;
	}

	public String getSalario() {
		return this.salario;
	}

	public void setSalario(String salario) {
		this.salario = salario;
	}

	public String getTipocontrato() {
		return this.tipocontrato;
	}

	public void setTipocontrato(String tipocontrato) {
		this.tipocontrato = tipocontrato;
	}

}