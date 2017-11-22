package com.ubosque.progII.modelo;

import java.io.Serializable;
import javax.persistence.*;

import org.eclipse.persistence.annotations.ReturnInsert;

import java.util.Date;


/**
 * The persistent class for the TITULOACADEMICO database table.
 * 
 */
@Entity
@NamedQuery(name="Tituloacademico.findAll", query="SELECT t FROM Tituloacademico t")
public class Tituloacademico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@ReturnInsert(returnOnly = true)
	@Column(name="TITACADEMICO_ID")
	private long titacademicoId;

	@Temporal(TemporalType.DATE)
	private Date fechafinal;

	@Temporal(TemporalType.DATE)
	private Date fechainicial;

	private String nivelestudio;

	@Column(name="PERSONA_ID")
	private Long personaId;

	private String titulo;

	private String universidad;

	public Tituloacademico() {
	}

	public long getTitacademicoId() {
		return this.titacademicoId;
	}

	public void setTitacademicoId(long titacademicoId) {
		this.titacademicoId = titacademicoId;
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

	public String getNivelestudio() {
		return this.nivelestudio;
	}

	public void setNivelestudio(String nivelestudio) {
		this.nivelestudio = nivelestudio;
	}

	public Long getPersonaId() {
		return this.personaId;
	}

	public void setPersonaId(Long personaId) {
		this.personaId = personaId;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getUniversidad() {
		return this.universidad;
	}

	public void setUniversidad(String universidad) {
		this.universidad = universidad;
	}

}