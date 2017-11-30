package com.ubosque.progII.servicio;

import javax.persistence.EntityManager;

import com.ubosque.progII.dto.EmpresaDTO;
import com.ubosque.progII.dto.PersonaDTO;
import com.ubosque.progII.helper.OfuscacionHelper;
import com.ubosque.progII.modelo.Empresa;
import com.ubosque.progII.modelo.Experiencialoboral;
import com.ubosque.progII.modelo.Persona;
import com.ubosque.progII.modelo.Tituloacademico;
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


	public void guardarPersona(PersonaDTO personaDTO) throws Exception{
		//guardo la referencia personal
		Persona personaReferencia = new Persona();
		personaReferencia.setNombres(personaDTO.getNombreReferencia());
		personaReferencia.setTelefono(personaDTO.getTelefonoReferencia());
		personaReferencia.setTiporeferencia(personaDTO.getTipoReferencia());
		personaReferencia.setDireccion(personaDTO.getDireccionReferencia());
		manager.persist(personaReferencia); //permite persistir la entidad en memoria volatil
		manager.flush();
		//guardo la persona
		Persona persona = new Persona();
		persona.setNombres(personaDTO.getNombrePersona());
		persona.setApellidos(personaDTO.getApellidoPersona());
		persona.setFechanacimiento(personaDTO.getFechaNacimiento());
		persona.setLugarnacimiento(personaDTO.getLugarNacimiento());
		persona.setDireccion(personaDTO.getDireccion());
		persona.setTelefono(personaDTO.getTelefono());
		persona.setEstadocivil(personaDTO.getEstadoCivil());
		persona.setCorreo(personaDTO.getCorreo());
		persona.setReferenciapersonal(personaReferencia.getPersonaId());//TODO
		manager.persist(persona);
		manager.flush();
		
		//Guardor la experiencia laboral
		Experiencialoboral exp = new Experiencialoboral();
		exp.setCargo(personaDTO.getCargoExl());
		exp.setEmpresa(personaDTO.getEmpresaExl());
		exp.setFechafinal(personaDTO.getFechaFinalExl());
		exp.setFechainicial(personaDTO.getFechaInicialExl());
		exp.setPersonaId(persona.getPersonaId());
		manager.persist(persona);
		
		//Guardar experiencia academica
		Tituloacademico academico = new Tituloacademico();
		academico.setFechafinal(personaDTO.getFechaFinal());
		academico.setFechainicial(personaDTO.getFechaInicial());
		academico.setNivelestudio(personaDTO.getNivelEstudio());
		academico.setTitulo(personaDTO.getTitulo());
		academico.setUniversidad(personaDTO.getUniversidad());
		academico.setPersonaId(persona.getPersonaId());
		manager.persist(academico);
		
		
		//Guardar el usuario
		Usuario usuario = new Usuario();
		String contrasenaCifrada = OfuscacionHelper.getInstance().ofuscarMensajePorAES(personaDTO.getContrasena());
		usuario.setContrasena(contrasenaCifrada);
		usuario.setPersonaId(persona.getPersonaId());
		usuario.setNombreusuario(personaDTO.getNombreUsuario());
		usuario.setUsuariorol("PE");
		manager.persist(usuario);
		
	}
}
