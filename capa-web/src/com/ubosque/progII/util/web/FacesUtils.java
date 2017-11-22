package com.ubosque.progII.util.web;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.application.Application;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.model.SelectItem;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.primefaces.context.RequestContext;



/**
 * @author yaayho
 */
public final class FacesUtils{

	public static final String REDIRECT = "?faces-redirect=true";

	// --------------------------------------------------------------------------------------------------
	/**
	 * Comparador de select items usando el label.
	 * 
	 * @author pgarcia
	 */
	public static Comparator<SelectItem> SELECTITEM_COMPARATOR_PORLABEL = new Comparator<SelectItem>(){
		@Override
		public int compare(SelectItem s1, SelectItem s2){
			return ((String) s1.getLabel()).compareTo((String) s2.getLabel());
		}
	};

	// --------------------------------------------------------------------------------------------------

	private FacesUtils (){
	}

	public final static FacesContext getFacesContext(){
		return FacesContext.getCurrentInstance();
	}

	public final static ExternalContext getExternalContext(){
		return getFacesContext().getExternalContext();
	}

	public final static Application getApplication(){
		return getFacesContext().getApplication();
	}

	public final static void renderResponse(){
		getFacesContext().renderResponse();
	}

	public final static void responseComplete(){
		getFacesContext().responseComplete();
	}

	public final static ServletContext getServletContext(){
		return ((ServletContext) getExternalContext().getContext());
	}

	public final static HttpSession getHttpSession(){
		return (HttpSession) getExternalContext().getSession(false);
	}

	public final static void invalidateSession(){
		getExternalContext().invalidateSession();
	}

	public final static HttpServletRequest getHttpServletRequest(){
		return (HttpServletRequest) getExternalContext().getRequest();
	}

	public final static HttpServletResponse getHttpServletResponse(){
		return (HttpServletResponse) getExternalContext().getResponse();
	}

	public final static String getContextName(){
		return getServletContext().getServletContextName();
	}

	public final static String getInitParameter(String parameterName){
		return getExternalContext().getInitParameter(parameterName);
	}

	private final static Flash getFlash(){
		return FacesUtils.getExternalContext().getFlash();
	}

	public final static Map<String, String> getRequestParameterMap(){
		return getExternalContext().getRequestParameterMap();
	}

	public final static Map<String, Object> getRequestMap(){
		return getExternalContext().getRequestMap();
	}

	public final static Map<String, Object> getSessionMap(){
		return getExternalContext().getSessionMap();
	}

	public final static Map<String, Object> getApplicationMap(){
		return getExternalContext().getApplicationMap();
	}

	public final static Object getRequestAttribute(String attributeName){
		Map<String, Object> map = getRequestMap();
		return map.get(attributeName);
	}

	public final static Object getFlashAttribute(String attributeName){
		return getFlash().get(attributeName);
	}

	public final static Object getSessionAttribute(String attributeName){
		Map<String, Object> map = getSessionMap();
		return map.get(attributeName);
	}

	public final static Object getApplicationAttribute(String attributeName){
		Map<String, Object> map = getApplicationMap();
		return map.get(attributeName);
	}

	public final static void setRequestAttribute(String attributeName, Object attributeValue){
		Map<String, Object> map = getRequestMap();
		map.put(attributeName, attributeValue);
	}

	public final static void setFlashAttribute(String attributeName, Object attributeValue){
		getFlash().put(attributeName, attributeValue);
	}

	public final static void setSessionAttribute(String attributeName, Object attributeValue){
		Map<String, Object> map = getSessionMap();
		map.put(attributeName, attributeValue);
	}

	public final static void setApplicationAttribute(String attributeName, Object attributeValue){
		Map<String, Object> map = getApplicationMap();
		map.put(attributeName, attributeValue);
	}

	public final static void keepFlashAttribute(String attributeName){
		getFlash().keep(attributeName);
	}

	public final static Object removeRequestAttribute(String attributeName){
		Map<String, Object> map = getRequestMap();
		return map.remove(attributeName);
	}

	public final static Object removeFlashAttribute(String attributeName){
		return getFlash().remove(attributeName);
	}

	public final static Object removeSessionAttribute(String attributeName){
		Map<String, Object> map = getSessionMap();
		return map.remove(attributeName);
	}

	public final static Object removeApplicationAttribute(String attributeName){
		Map<String, Object> map = getApplicationMap();
		return map.remove(attributeName);
	}

	public final static boolean containsRequestAttribute(String attributeName){
		Map<String, Object> map = getRequestMap();
		return map.containsKey(attributeName);
	}

	public final static boolean containsFlashAttribute(String attributeName){
		return getFlash().containsKey(attributeName);

	}

	public final static boolean containsSessionAttribute(String attributeName){
		Map<String, Object> map = getSessionMap();
		return map.containsKey(attributeName);
	}

	public final static boolean containsApplicationAttribute(String attributeName){
		Map<String, Object> map = getApplicationMap();
		return map.containsKey(attributeName);
	}

	public final static String getRequestParameter(String parameterName){
		return getRequestParameterMap().get(parameterName);
	}

	public final static String getContextPath(){
		// getHttpServletRequest().getContextPath()
		return getServletContext().getContextPath();
	}

	public final static String getAbsolutePath(){
		return getAbsolutePath(null);
	}

	public final static String getAbsolutePath(String relativePath){
		relativePath = relativePath != null ? relativePath : "/";
		return getServletContext().getRealPath(relativePath);
	}

	
	
	public final static void sendRedirect(String location) throws IOException {
		getExternalContext().redirect(getContextPath().concat(location));
		getFacesContext().responseComplete();
	}
	
	public final static void sendRedirectExternalURL(String location) throws IOException{
		ExternalContext externalContext = getExternalContext();
		externalContext.redirect(location);
	}
	
	

	// Obtiene la IP del cliente web
	public final static String getRemoteAddress(){
		return getHttpServletRequest().getRemoteAddr();
	}
	
	// Obtiene la IP del cliente web
	public final static String getRemoteClientAddress() {
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		String ipAddress = request.getHeader("X-FORWARDED-FOR");
		if (ipAddress != null) {
			ipAddress = ipAddress.split("\\s*,\\s*", 2)[0];
		} else {
			ipAddress = request.getRemoteAddr();
		}
		return ipAddress;
	}

	// Obtiene la IP del servidor
	public final static String getServerAddress() throws Exception{
		try {
			InetAddress inetAddress = InetAddress.getLocalHost();
			return inetAddress.getHostAddress();
		} catch (UnknownHostException e) {
			String message = "Error obteniendo la IP del servidor web";
			throw new Exception(message, e);
		}
	}

	public final static void logout(){
		HttpSession session = getHttpSession();
		if (session != null) {
			session.invalidate();
		}
	}

	public static String getLabelSelectItemPorValue(Object value, Iterable<SelectItem> items){

		String label = null;
		if (items != null) {
			for (SelectItem item : items) {
				Object itemValue = item.getValue();
				if ((value == null && itemValue == null) || (itemValue != null && itemValue.equals(value))) {
					label = item.getLabel();
					break;
				}
			}
		}
		return label;
	}

	

	public static void limpiarSession(){
		limpiarSession(null);
	}

	public static void limpiarSession(String menuBean){
		Map<String, Object> mapa = FacesUtils.getSessionMap();
		Iterator<String> iterate = mapa.keySet().iterator();
		for (Iterator<String> iterator = iterate; iterate.hasNext();) {
			String nombre = (String) iterator.next();
			if (nombre.toLowerCase().contains("bean") && !nombre.equalsIgnoreCase(menuBean)) {
				FacesUtils.removeSessionAttribute(nombre);
			}
		}
	}

	public static RequestContext getRequestContext(){
		return RequestContext.getCurrentInstance();
	}

	public static String getUrlContext() throws MalformedURLException{
		URL url = new URL(getHttpServletRequest().getRequestURL().toString());
		URL newUrl = new URL(url.getProtocol(), url.getHost(), url.getPort(), getHttpServletRequest().getContextPath());
		return newUrl.toString();
	}

	/**
	 * Metodo que convierte de Long a BigInteger
	 * @param dato
	 * @return
	 */
	public static BigInteger convertirLongBigInteger(Long dato){
		BigInteger datoConvertido = new BigInteger(dato.toString());
		return datoConvertido;
	}

	
	
//----------------------------------------------------------------------------------------------	
	/**
	 * retorna el HttpServletRequest asociado al contexto faces
	 * 
	 * @author pgarcia
	 * @return
	 */
	public static HttpServletRequest getRequestFromFacesContext() {
		
		HttpServletRequest request = null;
		
		request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		
		return request;
	}
	
//----------------------------------------------------------------------------------------------	
	/**
	 * Retorna la url base de la aplicación. Algo de la forma http://localhost:8080:inscripcion-web.
	 * @return URL hasta el contexto sin slash.
	 */
	public static String getBaseURL() {
		String urlBase = "";
		HttpServletRequest request = FacesUtils.getRequestFromFacesContext();
		if (request != null) {
			urlBase = request.getRequestURL().toString().replace(request.getRequestURI(), "") + request.getContextPath();
		}
		return urlBase;
	}

//-------------------------------------------------	
	/**
	 * retorna la url base de la aplicación. Algo de la forma http://localhost:8080:inscripcion-web.
	 * Usa otra forma de obtenerla  (diferente a {@link FacesUtils#getBaseURL()} ) 
	 * 
	 * @author pgarcia
	 * @return
	 */
	public static String getBaseURL2() {
		
		String urlBase = "";
		HttpServletRequest request;
		
		request = FacesUtils.getRequestFromFacesContext();
		
		if (request != null) {
			String url = request.getRequestURL().toString();
			urlBase = url.substring(0, url.length() - request.getRequestURI().length()) + request.getContextPath();
		}
		
		return urlBase;
	}
	
//----------------------------------------------------------------------------------------------	
	/**
	 * retorna la url base de la aplicación, conteniendo la ip del servidor. 
	 * Algo de la forma http://192.168.2.69:8080:inscripcion-web
	 * 
	 * @author pgarcia
	 * @return
	 */
	public static String getBaseURLIP() {
		
		String urlBase = "";
		HttpServletRequest request;
		String localIP;
		
		request = FacesUtils.getRequestFromFacesContext();
		try {
			localIP = InetAddress.getLocalHost().toString().substring(InetAddress.getLocalHost().toString().indexOf("/") + 1);
		} 
		catch (UnknownHostException e) {
			return null;
		}
		if (request != null) {
			//D: request.getLocalAddr() no funciona bien cuando no se hace todo en el mismo servidor
			urlBase = request.getScheme() + "://" + localIP + ":" + request.getServerPort() 
					+ request.getContextPath();
		}
		
		return urlBase;
	}

//----------------------------------------------------------------------------------------------	
	/**
	 * retorna la ip del servidor donde corre la aplicación
	 * 
	 * @author pgarcia
	 * @return
	 */
	public static String getLocalIP() {
		
		String localIP;
		
		try {
			localIP = InetAddress.getLocalHost().toString().substring(InetAddress.getLocalHost().toString().indexOf("/") + 1);
		} 
		catch (UnknownHostException e) {
			return null;
		}
		
		return localIP;
	}
	
//-----------------------------------------------------------------------------------------------
	
	
//-----------------------------------------------------------------------------------------------
	/**
	 * Retorna una url con los parámetros get de sesión, tal que se pueden usar para redirección.
	 * De la forma /pages/...
	 * 
	 * @author pgarcia
	 * 
	 * @param location
	 * @param submodulo
	 * @return
	 * @throws IOException
	 */
	
	/**
	 * Método que se encarga de preparar el archivo para ser descargado
	 * por el usuario
	 * @param archivo
	 * @param nombre
	 */
	public final static void traerArchivo(byte[] archivo, String nombre){
		OutputStream out = null;
		try{
			HttpServletResponse response =(HttpServletResponse) FacesUtils.getExternalContext().getResponse();
			response.setContentType("application/octet-stream");
			response.setHeader("Content-disposition", "attachment;filename=" + nombre);
			out = response.getOutputStream();
			out.write(archivo);
			out.flush();
			out.close();
			FacesUtils.responseComplete();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
}