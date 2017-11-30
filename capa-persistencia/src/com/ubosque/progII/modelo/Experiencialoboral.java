package com.ubosque.progII.modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.eclipse.persistence.annotations.ReturnInsert;


/**
 * The persistent class for the EXPERIENCIALOBORAL database table.
 * 
 */
@Entity
@NamedQuery(name="Experiencialoboral.findAll", query="SELECT e FROM Experiencialoboral e")
public class Experiencialoboral implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@ReturnInsert(returnOnly = true)
	@Column(name="EXPLABORAL_ID")
	private long explaboralId;

	private String cargo;

	private String empresa;

	@Temporal(TemporalType.DATE)
	private Date fechafinal;
	
	@Temporal(TemporalType.DATE)
	private Date fechainicial;

	private String funciones;

	@Column(name="PERSONA_ID")
	private Long personaId;

	private String sector;

	public Experiencialoboral() {
	}

	public long getExplaboralId() {
		return this.explaboralId;
	}

	public void setExplaboralId(long explaboralId) {
		this.explaboralId = explaboralId;
	}

	public String getCargo() {
		return this.cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getEmpresa() {
		return this.empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public Date getFechafinal() {
		return this.fechafinal;
	}

	public void setFechafinal(Date fechafinal) {
		this.fechafinal = fechafinal;
	}

	public Date getFechainicial() {
		return this.fechainicial;
	}

	public void setFechainicial(Date fechainicial) {
		this.fechainicial = fechainicial;
	}

	public String getFunciones() {
		return this.funciones;
	}

	public void setFunciones(String funciones) {
		this.funciones = funciones;
	}

	public Long getPersonaId() {
		return this.personaId;
	}

	public void setPersonaId(Long personaId) {
		this.personaId = personaId;
	}

	public String getSector() {
		return this.sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

}