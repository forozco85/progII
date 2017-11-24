package com.ubosque.progII.web.bean;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.ubosque.progII.dto.EmpresaDTO;
import com.ubosque.progII.fachada.GestionFachadaLocal;

@ManagedBean(name = VistaUsuarioBean.NOMBREBEAN)
@SessionScoped
public class FormularioEmpresaBean {
	
	public static final String NOMBREBEAN = "formularioEmpresaBean";

	private String nombreEmpresa;
	private String nombreUsuarioEmpresa;
	private String contrasenaUsuarioEmpresa;
	private String perfil;
	private String sector;
	private String telefono;
	private String correo;
	
	@EJB
	private GestionFachadaLocal gestionFachada;
	
	@PostConstruct
	public void init(){
		
	}
	
	
	public void guardarEmpresa() {
		EmpresaDTO empresaDTO = new EmpresaDTO();
		empresaDTO.setContrasenaUsuarioEmpresa(contrasenaUsuarioEmpresa);
		empresaDTO.setCorreo(correo);
		empresaDTO.setNombreEmpresa(nombreEmpresa);
		empresaDTO.setNombreUsuarioEmpresa(nombreUsuarioEmpresa);
		empresaDTO.setPerfil(perfil);
		empresaDTO.setSector(sector);
		empresaDTO.setTelefono(telefono);
		try {
			gestionFachada.guardarEmpresa(empresaDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @return the nombreEmpresa
	 */
	public String getNombreEmpresa() {
		return nombreEmpresa;
	}
	/**
	 * @param nombreEmpresa the nombreEmpresa to set
	 */
	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}
	/**
	 * @return the nombreUsuarioEmpresa
	 */
	public String getNombreUsuarioEmpresa() {
		return nombreUsuarioEmpresa;
	}
	/**
	 * @param nombreUsuarioEmpresa the nombreUsuarioEmpresa to set
	 */
	public void setNombreUsuarioEmpresa(String nombreUsuarioEmpresa) {
		this.nombreUsuarioEmpresa = nombreUsuarioEmpresa;
	}
	/**
	 * @return the perfil
	 */
	public String getPerfil() {
		return perfil;
	}
	/**
	 * @param perfil the perfil to set
	 */
	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}
	/**
	 * @return the sector
	 */
	public String getSector() {
		return sector;
	}
	/**
	 * @param sector the sector to set
	 */
	public void setSector(String sector) {
		this.sector = sector;
	}
	/**
	 * @return the telefono
	 */
	public String getTelefono() {
		return telefono;
	}
	/**
	 * @param telefono the telefono to set
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	/**
	 * @return the correo
	 */
	public String getCorreo() {
		return correo;
	}
	/**
	 * @param correo the correo to set
	 */
	public void setCorreo(String correo) {
		this.correo = correo;
	}

	/**
	 * @return the contrasenaUsuarioEmpresa
	 */
	public String getContrasenaUsuarioEmpresa() {
		return contrasenaUsuarioEmpresa;
	}

	/**
	 * @param contrasenaUsuarioEmpresa the contrasenaUsuarioEmpresa to set
	 */
	public void setContrasenaUsuarioEmpresa(String contrasenaUsuarioEmpresa) {
		this.contrasenaUsuarioEmpresa = contrasenaUsuarioEmpresa;
	}
	
	
	
	
	
}
