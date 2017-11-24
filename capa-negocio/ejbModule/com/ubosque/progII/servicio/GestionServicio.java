package com.ubosque.progII.servicio;

import javax.persistence.EntityManager;

import com.ubosque.progII.dto.EmpresaDTO;
import com.ubosque.progII.helper.OfuscacionHelper;
import com.ubosque.progII.modelo.Empresa;
import com.ubosque.progII.modelo.Usuario;

public class GestionServicio {
	private EntityManager manager;
	
	
	public GestionServicio(EntityManager manager) {
		this.manager = manager;
	}


	public void guardarEmpresa(EmpresaDTO empresaDTO) throws Exception{
		
		
		Empresa empresa = new Empresa();
		empresa.setCorreo(empresaDTO.getCorreo());
		empresa.setPerfil(empresaDTO.getPerfil());
		empresa.setSector(empresaDTO.getSector());
		empresa.setTelefono(empresaDTO.getTelefono());
		manager.persist(empresa); //permite persistir la entidad en memoria volatil
		manager.flush();//permite llamar la secuencia a través del disparador
		
		Usuario usuario = new Usuario();
		String contrasenaCifrada = OfuscacionHelper.getInstance().ofuscarMensajePorAES(empresaDTO.getContrasenaUsuarioEmpresa());
		usuario.setContrasena(contrasenaCifrada);
		usuario.setNombreusuario(empresaDTO.getContrasenaUsuarioEmpresa());
		usuario.setUsuariorol("EM");
		usuario.setEmpresaId(empresa.getEmpresaId());
		manager.persist(usuario);
		
	}
}
