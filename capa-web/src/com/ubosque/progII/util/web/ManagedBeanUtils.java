package com.ubosque.progII.util.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.component.ContextCallback;
import javax.faces.component.UIComponent;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;


//import co.gov.icfes.misional.util.comun.ReflectionUtils;

/**
 * @author yaayho
 */
public final class ManagedBeanUtils {

	private ManagedBeanUtils() {
	}

	public final static UIViewRoot getViewRoot() {
		return FacesUtils.getFacesContext().getViewRoot();
	}

	public final static Object getComponentAttribute(UIComponent component,
			String attributeName) {
		return component.getAttributes().get(attributeName);
	}

	public final static UIComponent findComponent(String clientId) {
		FacesContext context = FacesUtils.getFacesContext();
		ComponentContextCallback callback = new ComponentContextCallback();
		getViewRoot().invokeOnComponent(context, clientId, callback);
		return callback.getComponent();
	}

	// Usado en método UIComponent findComponent(String clientId)
	private static final class ComponentContextCallback implements
			ContextCallback {
		private UIComponent component;

		public void invokeContextCallback(FacesContext arg0, UIComponent arg1) {
			component = arg1;
		}

		public UIComponent getComponent() {
			return component;
		}
	};

	public static final String getLabelFromSelectItems(Object value,
			Iterable<SelectItem> items) {
		String label = null;
		if (items != null) {
			for (SelectItem item : items) {
				Object itemValue = item.getValue();
				if ((value == null && itemValue == null)
						|| (itemValue != null && itemValue.equals(value))) {
					label = item.getLabel();
					break;
				}
			}
		}
		return label;
	}

	public static final int getIndexFromSelectItems(Object value,
			Iterable<SelectItem> items) {
		int index = 0;
		if (items != null) {
			for (SelectItem item : items) {
				Object itemValue = item.getValue();
				if ((value == null && itemValue == null)
						|| (itemValue != null && itemValue.equals(value))) {
					return index;
				}
				index++;
			}
		}
		return 0;
	}

//	public static final List<SelectItem> loadSelectItems(
//			List<? extends Serializable> list, String labelField,
//			String valueField) throws Exception {
//		return loadSelectItems(list, labelField, labelField, valueField);
//	}

//	public static final List<SelectItem> loadSelectItems(
//			List<? extends Serializable> list, String labelField,
//			String descripcionField, String valueField)
//			throws Exception {
//		List<SelectItem> items = new ArrayList<SelectItem>();
//		if (list != null) {
//			for (Serializable entity : list) {
//				try {
//					String label = (String) ReflectionUtils.getSimpleProperty(
//							entity, labelField);
//
//					String descripcion = (String) ReflectionUtils
//							.getSimpleProperty(entity, descripcionField);
//					Object value = ReflectionUtils.getSimpleProperty(entity,
//							valueField);
//
//					SelectItem item = new SelectItem();
//					item.setLabel(label);
//					item.setDescription(descripcion);
//					item.setValue(value);
//					items.add(item);
//				} catch (Exception e) {
//					throw new Exception(
//							"Error cargando combo: propiedades (" + labelField
//									+ descripcionField + valueField + ")", e);
//				}
//
//			}
//		}
//		return items;
//	}

	public static final <T> T getManagedBean(Class<T> type, String beanName) {
		FacesContext context = FacesUtils.getFacesContext();
		return (T) FacesUtils.getApplication().evaluateExpressionGet(context,
				"#{" + beanName + "}", type);
	}

	public static final void removeManagedBean(String beanName) {
		FacesUtils.getApplicationMap().remove(beanName);
		FacesUtils.getSessionMap().remove(beanName);
		FacesUtils.getRequestMap().remove(beanName);
	}

}