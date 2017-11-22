package com.ubosque.progII.modelo;

import java.io.Serializable;
import javax.persistence.*;

import org.eclipse.persistence.annotations.ReturnInsert;

import java.util.Date;


/**
 * The persistent class for the PERSONA database table.
 * 
 */
@Entity
@NamedQuery(name="Persona.findAll", query="SELECT p FROM Persona p")
public class Persona implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@ReturnInsert(returnOnly = true)
	@Column(name="PERSONA_ID")
	private long personaId;

	private String apellidos;

	@Column(name="CARGO_ID")
	private Long cargoId;

	private String correo;

	private String direccion;

	private String estadocivil;

	@Temporal(TemporalType.DATE)
	private Date fechanacimiento;

	private String lugarnacimiento;

	private String nombres;

	private String perfilprofesional;

	private Long referenciapersonal;

	private String telefono;

	private String tiporeferencia;

	public Persona() {
	}

	public long getPersonaId() {
		return this.personaId;
	}

	public void setPersonaId(long personaId) {
		this.personaId = personaId;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Long getCargoId() {
		return this.cargoId;
	}

	public void setCargoId(Long cargoId) {
		this.cargoId = cargoId;
	}

	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEstadocivil() {
		return this.estadocivil;
	}

	public void setEstadocivil(String estadocivil) {
		this.estadocivil = estadocivil;
	}

	public Date getFechanacimiento() {
		return this.fechanacimiento;
	}

	public void setFechanacimiento(Date fechanacimiento) {
		this.fechanacimiento = fechanacimiento;
	}

	public String getLugarnacimiento() {
		return this.lugarnacimiento;
	}

	public void setLugarnacimiento(String lugarnacimiento) {
		this.lugarnacimiento = lugarnacimiento;
	}

	public String getNombres() {
		return this.nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getPerfilprofesional() {
		return this.perfilprofesional;
	}

	public void setPerfilprofesional(String perfilprofesional) {
		this.perfilprofesional = perfilprofesional;
	}

	public Long getReferenciapersonal() {
		return this.referenciapersonal;
	}

	public void setReferenciapersonal(Long referenciapersonal) {
		this.referenciapersonal = referenciapersonal;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getTiporeferencia() {
		return this.tiporeferencia;
	}

	public void setTiporeferencia(String tiporeferencia) {
		this.tiporeferencia = tiporeferencia;
	}

}