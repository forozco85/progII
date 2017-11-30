package com.ubosque.progII.fachada;

import javax.ejb.Local;

import com.ubosque.progII.dto.EmpresaDTO;
import com.ubosque.progII.dto.PersonaDTO;

@Local
public interface GestionFachadaLocal {

	
	public void guardarEmpresa(EmpresaDTO empresaDTO) throws Exception;

	public void guardarPersona(PersonaDTO persona) throws Exception;
}
