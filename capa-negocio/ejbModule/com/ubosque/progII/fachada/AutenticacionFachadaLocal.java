package com.ubosque.progII.fachada;

import javax.ejb.Local;

import com.ubosque.progII.dto.UsuarioDTO;

@Local
public interface AutenticacionFachadaLocal {

	public UsuarioDTO autenticar(UsuarioDTO usuarioDTO) throws Exception;
}
