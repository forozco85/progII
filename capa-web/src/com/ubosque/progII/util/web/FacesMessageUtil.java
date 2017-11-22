package com.ubosque.progII.util.web;

import java.text.MessageFormat;
import java.util.List;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;


/**
 * @author yaayho
 */
public final class FacesMessageUtil {

	
	private static final String MSJ_MENSAJE_NO_RESULTADOS = "mensajeResultadosVacios";

	public final static String ID_GLOBAL = null;

	

	private FacesMessageUtil() {
	}

	

	public final static String getLocalizedMsg(String message, Object... params) {
		message = getLocalizedMsg(message);
		if (params != null) {
			message = MessageFormat.format(message, params);
		}
		return message;
	}

	

	public final static void addLocalizedMsgInfoGlobal(String message,
			Object... params) {
		addLocalizedMsgInfo(ID_GLOBAL, message, params);
	}

	public final static void addLocalizedMsgWarnGlobal(String message,
			Object... params) {
		addLocalizedMsgWarn(ID_GLOBAL, message, params);
	}

	public final static void addLocalizedMsgErrorGlobal(String message,
			Object... params) {
		addLocalizedMsgError(ID_GLOBAL, message, params);
	}

	public final static void addLocalizedMsgInfo(String idComponent,
			String message, Object... params) {
		addLocalizedMsg(FacesMessage.SEVERITY_INFO, idComponent, message,
				params);
	}

	public final static void addLocalizedMsgWarn(String idComponent,
			String message, Object... params) {
		addLocalizedMsg(FacesMessage.SEVERITY_WARN, idComponent, message,
				params);
	}

	public final static void addLocalizedMsgError(String idComponent,
			String message, Object... params) {
		addLocalizedMsg(FacesMessage.SEVERITY_ERROR, idComponent, message,
				params);
	}

	public final static void addMessageInfo(String message) {
		addMessageInfo(ID_GLOBAL, message);
	}

	public final static void addMessageWarn(String message) {
		addMessageWarn(ID_GLOBAL, message);
	}

	public final static void addMessageError(String message) {
		addMessageError(ID_GLOBAL, message);
	}

	public final static void addMessageInfo(String idComponent, String message) {
		addMessage(FacesMessage.SEVERITY_INFO, idComponent, message);
	}

	public final static void addMessageWarn(String idComponent, String message) {
		addMessage(FacesMessage.SEVERITY_WARN, idComponent, message);
	}

	public final static void addMessageError(String idComponent, String message) {
		addMessage(FacesMessage.SEVERITY_ERROR, idComponent, message);
	}

	public final static void addMessageError(Exception exception) {
		addMessageError(ID_GLOBAL, exception);
	}

	public final static void addMessageError(String idComponent,
			Exception exception) {
		String message = exception.getMessage();
		if (message == null || message.isEmpty()) {
			// agregarMensajeError(Constants.MENSAJE_ERROR_GENERAL);
		} else {
			message = toFormatMessage(message);
			addMessageError(idComponent, message);
		}
	}

	public final static void addLocalizedMsg(Severity severity,
			String idComponent, String message, Object... params) {
		String mensaje = getLocalizedMsg(message, params);
		addFacesMessage(severity, idComponent, mensaje);
	}

	public final static void addMessage(Severity severity, String idComponent,
			String message) {
		addFacesMessage(severity, idComponent, message);
	}

	public final static void addFacesMessage(Severity severity,
			String idComponent, String message) {
		FacesContext context = FacesUtils.getFacesContext();
		FacesMessage msg = createFacesMessage(severity, message, null);
		context.addMessage(idComponent, msg);
	}

	public final static FacesMessage createFacesMessage(Severity severity,
			String summary, String detail) {
		return new FacesMessage(severity, summary, detail);
	}

	public final static void addMessage(List<?> list) {
		addMessage(ID_GLOBAL, list);
	}

	public final static void addMessage(String idComponent, List<?> list) {
		if (JavaUtils.isEmpty(list)) {
			addLocalizedMsgInfo(idComponent, MSJ_MENSAJE_NO_RESULTADOS);
		}
	}

	private final static String toFormatMessage(String message) {
		if (JavaUtils.isNotEmpty(message)) {
			String[] stringSplit = message.split("Excepcion: ");
			if (stringSplit.length > 1) {
				return stringSplit[1];
			} else {
				return stringSplit[0];
			}
		} else {
			return message;
		}
	}
	
	
}