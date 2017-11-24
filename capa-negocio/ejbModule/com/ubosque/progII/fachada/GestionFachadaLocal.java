package com.ubosque.progII.fachada;

import javax.ejb.Local;

import com.ubosque.progII.dto.EmpresaDTO;

@Local
public interface GestionFachadaLocal {

	
	public void guardarEmpresa(EmpresaDTO empresaDTO) throws Exception;
}
