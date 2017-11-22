package com.ubosque.progII.persistencia.utilitarios;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.TemporalType;

/**
 * Clase que se usa para pasar los par&aacute;metros que se usar&aacute;n como filtro en un query 
 * a un entity (tabla).
 * Para cada par&aacute;metro se define como m&iacute;nimo el nombre, valor, y el operador que se usa para la comparaci&oacute;n 
 * 
 * @param <T>
 */
/*
 * @documentation pgarcia
 */
public class ParametroQuery<T extends Serializable> implements Serializable {
	private static final long serialVersionUID = 1L;

	public enum Operador {
		IGUAL, DIFERENTE, NO_NULO, NULO, MAYOR_QUE, MENOR_QUE, MAYOR_IGUAL_QUE, MENOR_IGUAL_QUE, COMO, EN
	}

	private String nombre;
	private int orden;
	private T valor;
	private TemporalType temporalType;

	private Operador operador;

	public ParametroQuery() {
		this(null);
	}

	public ParametroQuery(String nombre) {
		this(nombre, null);
	}

	public ParametroQuery(String nombre, T valor) {
		this(nombre, valor, null);
	}

	public ParametroQuery(int orden, T valor) {
		this(orden, valor, null);
	}

	public ParametroQuery(String nombre, T valor, TemporalType temporalType) {
		this(nombre, valor, temporalType, Operador.IGUAL);
	}

	public ParametroQuery(int orden, T valor, TemporalType temporalType) {
		this(null, orden, valor, temporalType, Operador.IGUAL);
	}

	public ParametroQuery(String nombre, T valor, TemporalType temporalType,
			Operador operador) {
		this(nombre, 0, valor, temporalType, operador);
	}

	public ParametroQuery(String nombre, int orden, T valor,
			TemporalType temporalType, Operador operador) {
		this.nombre = nombre;
		this.orden = orden;
		this.valor = valor;
		this.temporalType = temporalType;
		this.operador = operador;
	}

	public static <V extends Serializable> ParametroQuery<V> crearParametro(
			String nombre, V valor) {
		return new ParametroQuery<V>(nombre, valor);
	}

	public static <V extends Serializable> ParametroQuery<V> crearParametro(
			int orden, V valor) {
		return new ParametroQuery<V>(orden, valor);
	}

	public static <V extends Serializable> ParametroQuery<V> crearParametro(
			String nombre, V valor, Operador operador) {
		return new ParametroQuery<V>(nombre, valor, null, operador);
	}

	public static <V extends Date> ParametroQuery<V> crearParametro(
			String nombre, V valor, TemporalType temporalType) {
		return new ParametroQuery<V>(nombre, valor, temporalType);
	}

	public static <V extends Date> ParametroQuery<V> crearParametro(
			String nombre, V valor, TemporalType temporalType, Operador operador) {
		return new ParametroQuery<V>(nombre, valor, temporalType, operador);
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getOrden() {
		return orden;
	}

	public void setOrden(int orden) {
		this.orden = orden;
	}

	public T getValor() {
		return this.valor;
	}

	public void setValor(T valor) {
		this.valor = valor;
	}

	public TemporalType getTemporalType() {
		return this.temporalType;
	}

	public void setTemporalType(TemporalType temporalType) {
		this.temporalType = temporalType;
	}

	public void setOperador(Operador operador) {
		this.operador = operador;
	}

	public Operador getOperador() {
		return operador;
	}
}
