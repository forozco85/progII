package com.ubosque.progII.modelo;

import java.io.Serializable;
import javax.persistence.*;

import org.eclipse.persistence.annotations.ReturnInsert;



/**
 * The persistent class for the USUARIO database table.
 * 
 */
@Entity
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public static final String QUERY_AUTENTICAR = "Usuario.QUERY_AUTENTICAR";

	@Id
	@ReturnInsert(returnOnly = true)
	@Column(name="USUARIO_ID")
	private long usuarioId;

	@Column(name="CONTRASENA")
	private String contrasena;

	@Column(name="EMPRESA_ID")
	private Long empresaId;
	
	@Column(name="NOMBREUSUARIO")
	private String nombreusuario;

	@Column(name="PERSONA_ID")
	private Long personaId;
	
	@Column(name="USUARIOROL")
	private String usuariorol;

	public Usuario() {
	}

	public long getUsuarioId() {
		return this.usuarioId;
	}

	public void setUsuarioId(long usuarioId) {
		this.usuarioId = usuarioId;
	}

	public String getContrasena() {
		return this.contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public Long getEmpresaId() {
		return this.empresaId;
	}

	public void setEmpresaId(Long empresaId) {
		this.empresaId = empresaId;
	}

	public String getNombreusuario() {
		return this.nombreusuario;
	}

	public void setNombreusuario(String nombreusuario) {
		this.nombreusuario = nombreusuario;
	}

	public Long getPersonaId() {
		return this.personaId;
	}

	public void setPersonaId(Long personaId) {
		this.personaId = personaId;
	}

	public String getUsuariorol() {
		return this.usuariorol;
	}

	public void setUsuariorol(String usuariorol) {
		this.usuariorol = usuariorol;
	}

}