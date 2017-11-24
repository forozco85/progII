package com.ubosque.progII.dto;

import java.io.Serializable;

import com.ubosque.progII.modelo.Cargo;
import com.ubosque.progII.modelo.Usuario;


public class UsuarioDTO implements Serializable{
	
	public static final String NOMBRE_ATRIBUTO = "ATRIBUTO_USUARIO_DTO";
	/**
	 * 
	 */
	private static final long serialVersionUID = 2299223017141353530L;
	private long usuarioId;

	private String contrasena;

	private Long empresaId;

	private String nombreusuario;

	private Long personaId;

	private String usuariorol;
	
	public UsuarioDTO (){
		
	}
	
	public UsuarioDTO (Usuario usuario){
		usuarioId = usuario.getUsuarioId();
		this.nombreusuario = usuario.getNombreusuario();
		contrasena = usuario.getContrasena();
		empresaId = usuario.getEmpresaId();
		personaId = usuario.getPersonaId();
		usuariorol = usuario.getUsuariorol();
	}
	/**
	 * @return the usuarioId
	 */
	public long getUsuarioId() {
		return usuarioId;
	}
	/**
	 * @param usuarioId the usuarioId to set
	 */
	public void setUsuarioId(long usuarioId) {
		this.usuarioId = usuarioId;
	}
	/**
	 * @return the contrasena
	 */
	public String getContrasena() {
		return contrasena;
	}
	/**
	 * @param contrasena the contrasena to set
	 */
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	/**
	 * @return the empresaId
	 */
	public Long getEmpresaId() {
		return empresaId;
	}
	/**
	 * @param empresaId the empresaId to set
	 */
	public void setEmpresaId(Long empresaId) {
		this.empresaId = empresaId;
	}
	/**
	 * @return the nombreusuario
	 */
	public String getNombreusuario() {
		return nombreusuario;
	}
	/**
	 * @param nombreusuario the nombreusuario to set
	 */
	public void setNombreusuario(String nombreusuario) {
		this.nombreusuario = nombreusuario;
	}
	/**
	 * @return the personaId
	 */
	public Long getPersonaId() {
		return personaId;
	}
	/**
	 * @param personaId the personaId to set
	 */
	public void setPersonaId(Long personaId) {
		this.personaId = personaId;
	}
	/**
	 * @return the usuariorol
	 */
	public String getUsuariorol() {
		return usuariorol;
	}
	/**
	 * @param usuariorol the usuariorol to set
	 */
	public void setUsuariorol(String usuariorol) {
		this.usuariorol = usuariorol;
	}
	
	
	
	
	
}
