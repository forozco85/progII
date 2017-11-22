package com.ubosque.progII.util.web;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class JavaUtils {

	public static int DECIMAL = 10;
	public static int BINARY = 2;

	private JavaUtils() {
	}

	public static final boolean isEquals(Object value1, Object value2) {
		if (value1 != null) {
			return value1.equals(value2);
		} else {
			return (value2 == null);
		}
	}

	public static final boolean isEmpty(String value) {
		return (value == null || value.trim().isEmpty());
	}

	public static final boolean isNotEmpty(String value) {
		return (value != null && !value.trim().isEmpty());
	}

	public static final boolean isEmpty(Collection<?> collection) {
		return (collection == null || collection.isEmpty());
	}

	public static final boolean isNotEmpty(Collection<?> collection) {
		return (collection != null && !collection.isEmpty());
	}

	public static final boolean isEmpty(Map<?, ?> map) {
		return (map == null || map.isEmpty());
	}

	public static final boolean isNotEmpty(Map<?, ?> map) {
		return (map != null && !map.isEmpty());
	}

	public static final <T> boolean isEmpty(T[] array) {
		return (array == null || array.length == 0);
	}

	public static final <T> boolean isNotEmpty(T[] array) {
		return (array != null && array.length > 0);
	}
	
	public static final boolean isEmpty(Number value, int emptyValue) {
		return (value == null || value.longValue() == emptyValue);
	}
	
	// emptyValue is (-1)
	public static final boolean isEmpty(Number value) {
		return isEmpty(value, -1);
	}

	public static final String trimIgnoreNull(String string) {
		return string != null ? string.trim() : "";
	}

	public static final boolean isInteger(String text) {
		try {
			Integer.parseInt(text);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public static final boolean isLong(String text) {
		try {
			Long.parseLong(text);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public static final boolean isFloat(String text) {
		try {
			Float.parseFloat(text);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public static final boolean isDouble(String text) {
		try {
			Double.parseDouble(text);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public static final boolean isNumeric(String text) {
		return (text.matches("[0-9]*"));
	}

	public static final boolean parseBoolean(Number valorBooleano2Number) {
		if (valorBooleano2Number == null) {
			throw new NullPointerException("El parámetro no puede ser nulo");
		}
		int valorNumerico = valorBooleano2Number.intValue();
		if (valorNumerico > 1 && valorNumerico < 0) {
			throw new IllegalArgumentException("El parámetro debe ser 1 o 0");
		}
		return (valorNumerico == 1);
	}

	public static final String getValueAsString(Object o) {
		if (o != null) {
			return o.toString();
		}
		return "";
	}

	

	public static final <T> List<T> asList(
			T[] array) {
		List<T> list = new ArrayList<T>(array.length);
		for (int index = 0; index < array.length; index++) {
			list.add(array[index]);
		}
		return list;
	}

	public static final <E> List<E> removeDuplicates(List<E> list) {
		Set<E> set = new HashSet<E>(list);
		list.clear();
		list.addAll(set);
		return list;
	}

	public static String convertStackTraceToString(Exception e) {
		// 15/08/2013 - Carlos Diaz Maya - Se optimiza el metodo
		StringWriter wr = new StringWriter();
		PrintWriter pwr = new PrintWriter(wr);
		e.printStackTrace(pwr);
		return wr.toString();
	}

	public static int convertToRadix(String valor, int radix) {
		return Integer.parseInt(valor, radix);
	}
	
	public static double redondear( double numero, int decimales ) {
	    return Math.round(numero*Math.pow(10,decimales))/Math.pow(10,decimales);
	 }
	
	

	/**
	 * Convierte un BigDecimal a Double.
	 * @param number BigDecimal a convertir
	 * @return Number como Double.
	 */
	public static Double toDouble(BigDecimal number){
		return number == null ? null : number.doubleValue();
	}
	
	/**
	 * Convierte un BigDecimal a Long.
	 * @param number BigDecimal a convertir
	 * @return Number como Long.
	 */
	public static Long toLong(BigDecimal number){
		return number == null ? null : number.longValue();
	}
	/**
	 * 
	 * @param value
	 * @return
	 */
	public static final boolean isEmpty(StringBuffer value) {
		return (value == null || value.length()==0);
	}

	/**
	 * 
	 * @param value
	 * @return
	 */
	public static final boolean isNotEmpty(StringBuffer value) {
		return (value != null && value.length()>0);
	}
}