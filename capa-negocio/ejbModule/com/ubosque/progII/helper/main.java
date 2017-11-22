package com.ubosque.progII.helper;

public class main {

	public static void main(String[] args) {
		OfuscacionHelper ofuscacion = OfuscacionHelper.getInstance();
		try {
			String mensaje = ofuscacion.ofuscarMensajePorAES("a");
			System.out.println(mensaje);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
