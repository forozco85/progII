package com.ubosque.progII.helper;

import java.security.Key;
import java.util.ArrayList;
import java.util.List;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

public class OfuscacionHelper {
	/** Llave para el cifrado y descifrado. */
	private Key key;

	/** Clave de cifrado y descifrado. */
	private static final String CLAVE = "*$ZX7UGW2017*$_6YT58";

	/** Objeto con unica instancia. */
	private static OfuscacionHelper cifrado;
	/***/
	private List<String> listaCaracteres;

	private OfuscacionHelper() {
		key = new SecretKeySpec(CLAVE.getBytes(), 0, 16, "AES");
		listaCaracteres = new ArrayList<String>();
		listaCaracteres.add("a");
		listaCaracteres.add("y");
		listaCaracteres.add("c");
		listaCaracteres.add("n");
		listaCaracteres.add("e");
		listaCaracteres.add("f");
		listaCaracteres.add("r");
		listaCaracteres.add("s");
		listaCaracteres.add("t");
		listaCaracteres.add("z");

	}

	/**
	 * Método que obtiene una instancia de la clase.
	 * 
	 * @return instancia CifradoHelper.
	 */
	public static OfuscacionHelper getInstance() {
		if (cifrado == null) {
			cifrado = new OfuscacionHelper();
		}
		return cifrado;
	}

	/**
	 * Método que se encarga de cifrar un mensaje.
	 * @param mensaje mensaje original.
	 * @return texto con el contenido del mensaje cifrado.
	 * @throws SistemaExcepcion si ocurre algún error en el proceso de descifrar.
	 * @throws AplicacionExcepcion si ocurre algún error en el parametro de entrada.
	 */
	public final String ofuscarMensajePorMetodoCesar(final String mensaje) throws Exception {
		if (mensaje == null) {
			throw new Exception("El mensaje a cifrar es nulo");
		}
		StringBuffer mensajeCifrado = new StringBuffer();
		final char[] arreglo = mensaje.toCharArray();
		for (char dato : arreglo) {
			mensajeCifrado.append(listaCaracteres.get(Integer.valueOf(String.valueOf(dato)).intValue()));
		}
		return mensajeCifrado.toString();
	}

	/***
	 * Método usado para descifrar mensaje. 
	 * @param mensaje mensaje que se quiere descifrar
	 * @return texto con el mensaje descifrar
	 * @throws SistemaExcepcion si ocurre algún error en el proceso de descifrar.
	 * @throws AplicacionExcepcion si ocurre algún error en el parametro de entrada.
	 */
	public final String desofuscarMensajePorMetodoCesar(String mensaje) throws Exception {
		if (mensaje == null) {
			throw new Exception("El mensaje a descifrar es nulo.");
		}
		final StringBuffer mensajeDescifrado = new StringBuffer();
		final char[] arreglo = mensaje.toCharArray();
		for (char dato : arreglo) {
			mensajeDescifrado.append(listaCaracteres.indexOf(String.valueOf(dato)));
		}
		return mensajeDescifrado.toString();

	}

	/**
	 * Método que se encarga de cifrar un mensaje.
	 * @param mensaje mensaje original.
	 * @return texto con el contenido del mensaje cifrado.
	 * @throws SistemaExcepcion si ocurre algún error en el proceso de descifrar.
	 * @throws AplicacionExcepcion si ocurre algún error en el parametro de entrada.
	 */
	public final String ofuscarMensajePorAES(final String mensaje) throws Exception {
		if (mensaje == null) {
			throw new Exception("El mensaje a cifrar es nulo");
		}
		Key key = new SecretKeySpec(CLAVE.getBytes(), 0, 16, "AES");
		Cipher aes;
		String mensajeCifrado = null;
		try {
			aes = Cipher.getInstance("AES/ECB/PKCS5Padding");
			aes.init(Cipher.ENCRYPT_MODE, key);
			byte[] encriptado = aes.doFinal(mensaje.getBytes());
			mensajeCifrado = DatatypeConverter.printBase64Binary(encriptado);
		} catch (Exception e) {
			throw new Exception("Error cifrando contenido", e);
		}
		return mensajeCifrado;
	}

	/***
	 * Método usado para descifrar mensaje.
	 * 
	 * @param mensaje
	 *            mensaje que se quiere descifrar
	 * @return texto con el mensaje descifrar
	 * @throws SistemaExcepcion
	 *             si ocurre algún error en el proceso de descifrar.
	 * @throws AplicacionExcepcion
	 *             si ocurre algún error en el parametro de entrada.
	 */
	public final String desofuscarMensajePorAES(final String mensaje) throws Exception {
		if (mensaje == null) {
			throw new Exception("El mensaje a descifrar es nulo.");
		}
		String mensajeDescifrado;
		try {
			Cipher aes2 = Cipher.getInstance("AES/ECB/PKCS5Padding");
			aes2.init(Cipher.DECRYPT_MODE, key);
			byte[] cifrado = DatatypeConverter.parseBase64Binary(mensaje);
			byte[] descifrado = aes2.doFinal(cifrado);
			mensajeDescifrado = new String(descifrado);
		} catch (Exception e) {
			throw new Exception("Error al descrifrar contenido", e);
		}
		return mensajeDescifrado;
	}
}
