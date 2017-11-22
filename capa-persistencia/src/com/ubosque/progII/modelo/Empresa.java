package com.ubosque.progII.modelo;

import java.io.Serializable;
import javax.persistence.*;

import org.eclipse.persistence.annotations.ReturnInsert;


/**
 * The persistent class for the EMPRESA database table.
 * 
 */
@Entity
@NamedQuery(name="Empresa.findAll", query="SELECT e FROM Empresa e")
public class Empresa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@ReturnInsert(returnOnly = true)
	@Column(name="EMPRESA_ID")
	private long empresaId;

	private String correo;

	private String perfil;

	private String sector;

	private String telefono;

	public Empresa() {
	}

	public long getEmpresaId() {
		return this.empresaId;
	}

	public void setEmpresaId(long empresaId) {
		this.empresaId = empresaId;
	}

	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getPerfil() {
		return this.perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	public String getSector() {
		return this.sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

}