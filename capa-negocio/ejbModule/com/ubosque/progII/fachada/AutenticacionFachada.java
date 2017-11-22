package com.ubosque.progII.fachada;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.ubosque.progII.dto.UsuarioDTO;
import com.ubosque.progII.servicio.AutenticacionServicio;



/**
 * Session Bean implementation class AutenticacionFachada
 */
@Stateless
@LocalBean
public class AutenticacionFachada implements AutenticacionFachadaLocal {

	
	@PersistenceContext
	private EntityManager manager;//@deberia estar en la superclase :(
	
	
	private AutenticacionServicio autenticacionServicio;
	
	//servicios
	
	@PostConstruct
	public void init() {
		autenticacionServicio = new AutenticacionServicio(manager);
	}
    /**
     * Default constructor. 
     */
    public AutenticacionFachada() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public UsuarioDTO autenticar(UsuarioDTO usuarioDTO) throws Exception {
		return autenticacionServicio.autenticar(usuarioDTO);
	}

}
