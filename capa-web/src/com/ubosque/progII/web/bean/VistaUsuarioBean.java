package com.ubosque.progII.web.bean;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.ubosque.progII.dto.UsuarioDTO;
import com.ubosque.progII.util.web.FacesUtils;



@ManagedBean(name = VistaUsuarioBean.NOMBREBEAN)
@SessionScoped
public class VistaUsuarioBean {
	public static final String NOMBREBEAN = "vistaUsuarioBean";

	private UsuarioDTO usuarioDTO;
	private String nombreFuncionario;

	@PostConstruct
	public void init() {
		usuarioDTO = (UsuarioDTO) FacesUtils.getSessionAttribute(UsuarioDTO.NOMBRE_ATRIBUTO);
		//nombreFuncionario = usuarioDTO.getUsuario();
	}

	

	public void cerrarSesion() {
		try {
			FacesUtils.sendRedirect("/pages/autenticacion.jsf");
			FacesUtils.logout();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void redirigirConsultarProceso() {
		try {
			// System.out.println("autenticacion exitosa");
			// FacesUtils.setSessionAttribute(UsuarioDTO.NOMBRE_ATRIBUTO, usuarioDTO);
			FacesContext context = FacesContext.getCurrentInstance();
			// context.getExternalContext().getSessionMap().remove(VistaUsuarioBean.NOMBREBEAN);
			//FacesUtils.sendRedirect("/pages/consulta_proceso.jsf");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @return the usuarioDTO
	 */
	public UsuarioDTO getUsuarioDTO() {
		return usuarioDTO;
	}

	/**
	 * @param usuarioDTO
	 *            the usuarioDTO to set
	 */
	public void setUsuarioDTO(UsuarioDTO usuarioDTO) {
		this.usuarioDTO = usuarioDTO;
	}

	/**
	 * @return the nombreFuncionario
	 */
	public String getNombreFuncionario() {
		return nombreFuncionario;
	}

	/**
	 * @param nombreFuncionario
	 *            the nombreFuncionario to set
	 */
	public void setNombreFuncionario(String nombreFuncionario) {
		this.nombreFuncionario = nombreFuncionario;
	}

}
