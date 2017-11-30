package com.ubosque.progII.fachada;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.ubosque.progII.dto.EmpresaDTO;
import com.ubosque.progII.dto.PersonaDTO;
import com.ubosque.progII.servicio.GestionServicio;

/**
 * Session Bean implementation class GestionFachada
 */
@Stateless
@LocalBean
public class GestionFachada implements GestionFachadaLocal {

	@PersistenceContext
	private EntityManager manager;
	private GestionServicio gestionServicio;
	
	
	@PostConstruct
	public void init(){
		gestionServicio = new GestionServicio(manager);
	}
	
	
	
    /**
     * Default constructor. 
     */
    public GestionFachada() {
        // TODO Auto-generated constructor stub
    }

    @Override
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void guardarEmpresa(EmpresaDTO empresaDTO) throws Exception {
		gestionServicio.guardarEmpresa(empresaDTO);
		
	}



    @Override
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void guardarPersona(PersonaDTO persona) throws Exception {
		gestionServicio.guardarPersona(persona);
		
	}

}
