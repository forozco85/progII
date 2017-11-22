package com.ubosque.progII.servicio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TemporalType;

import com.ubosque.progII.dto.UsuarioDTO;
import com.ubosque.progII.helper.OfuscacionHelper;
import com.ubosque.progII.modelo.Usuario;
import com.ubosque.progII.persistencia.utilitarios.ParametroQuery;

public class AutenticacionServicio {
	private EntityManager manager;
	
	public AutenticacionServicio(EntityManager manager){
		this.manager = manager;
	}
	
	
	public UsuarioDTO autenticar(UsuarioDTO usuarioDTO ) throws Exception{
		List<ParametroQuery<?>> parametros = new ArrayList<ParametroQuery<?>>();
		parametros.add(ParametroQuery.crearParametro("nombreUsuario", usuarioDTO.getNombreusuario()));
		String contrasenaOfuscada = OfuscacionHelper.getInstance().ofuscarMensajePorAES(usuarioDTO.getContrasena());
		parametros.add(ParametroQuery.crearParametro("contrasena", contrasenaOfuscada ));
		
		Query query = crearNamedQuery(Usuario.QUERY_AUTENTICAR, parametros);
		query.setMaxResults(1);
		Object result = query.getSingleResult();
		Usuario usuario = (Usuario)result;
		UsuarioDTO usuarioEncontrado = new UsuarioDTO(usuario);
		
		return usuarioEncontrado;
	}
	
	
	
	public Query crearNamedQuery(String namedQuery, List<ParametroQuery<?>> parameters) {
		Query query = manager.createNamedQuery(namedQuery);
		query = asignarParametros(parameters, query);
		return query;
	}
	
	public Query asignarParametros(List<ParametroQuery<?>> parameters, Query query) {
		if (parameters != null) {
			for (ParametroQuery<?> param : parameters) {
				Object paramValue = param.getValor();
				if (paramValue instanceof Date) {
					TemporalType temporalType = (param.getTemporalType() == null) ? TemporalType.DATE : param.getTemporalType();
					asignarParametro(param, query, temporalType);
				} else {
					asignarParametro(param, query);
				}
			}
		}
		return query;
	}
	
	private void asignarParametro(ParametroQuery<?> param, Query query, TemporalType temporalType) {
		if (param.getNombre() != null) {
			query.setParameter(param.getNombre(), (Date) param.getValor(), temporalType);
		} else if (param.getOrden() > 0) {
			query.setParameter(param.getOrden(), (Date) param.getValor(), temporalType);
		}
	}
	
	private  void asignarParametro(ParametroQuery<?> param, Query query) {
		if (param.getNombre() != null) {
			query.setParameter(param.getNombre(), param.getValor());
		} else if (param.getOrden() > 0) {
			query.setParameter(param.getOrden(), param.getValor());
		}
	}
}
