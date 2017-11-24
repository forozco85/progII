package com.ubosque.progII.autenticacion.web.bean;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.ubosque.progII.dto.UsuarioDTO;
import com.ubosque.progII.fachada.AutenticacionFachadaLocal;
import com.ubosque.progII.util.web.FacesMessageUtil;
import com.ubosque.progII.util.web.FacesUtils;
import com.ubosque.progII.web.bean.VistaUsuarioBean;



@ManagedBean (name = AutenticacionBean.NOMBREBEAN)
@SessionScoped
public class AutenticacionBean {

	public static final String NOMBREBEAN = "autenticacionBean";
	/**
	 * 
	 */
	private String usuario;
	/**
	 * 
	 */
	private String contrasena;
	
	@EJB
	private AutenticacionFachadaLocal autenticacionFachada;
	
	
	
	public void autenticar(){
		try {
			UsuarioDTO usuarioDTO = new UsuarioDTO();
			usuarioDTO.setContrasena(contrasena);
			usuarioDTO.setNombreusuario(usuario);
			usuarioDTO = autenticacionFachada.autenticar(usuarioDTO);
			if(usuarioDTO == null) {
				FacesMessageUtil.addLocalizedMsgErrorGlobal("Error al autenticar, el nombre de usuario y/o contraseña es incorrecto.",null);
			}else {
				System.out.println("tipo de rol del usuario: "+usuarioDTO.getUsuariorol());
				if(usuarioDTO.getUsuariorol() != null && usuarioDTO.getUsuariorol().equals("AD")) {
					System.out.println("autenticacion exitosa");
					FacesUtils.setSessionAttribute(UsuarioDTO.NOMBRE_ATRIBUTO, usuarioDTO);
					FacesContext context = FacesContext.getCurrentInstance();
					context.getExternalContext().getSessionMap().remove(VistaUsuarioBean.NOMBREBEAN);
					FacesUtils.sendRedirect("/pages/vista_usuario_administrador.jsf");
				} else if(usuarioDTO.getUsuariorol() != null && !usuarioDTO.getUsuariorol().equals("AD")) {
					System.out.println("autenticacion exitosa");
					FacesUtils.setSessionAttribute(UsuarioDTO.NOMBRE_ATRIBUTO, usuarioDTO);
					FacesContext context = FacesContext.getCurrentInstance();
					context.getExternalContext().getSessionMap().remove(VistaUsuarioBean.NOMBREBEAN);
					FacesUtils.sendRedirect("/pages/vista_usuario.jsf");
				}
				
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	public void irAConsultaLibro(){
//		try {
//			ManagedBeanUtils.removeManagedBean(ConsultaLibrosBean.NOMBREBEAN);
//			FacesUtils.setSessionAttribute(EnumAtributosSesion.URL_RETORNO.getNombre(), "/pages/autenticacion.jsf");
//			FacesUtils.sendRedirect("/pages/consulta_libros.jsf");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	
	
}
