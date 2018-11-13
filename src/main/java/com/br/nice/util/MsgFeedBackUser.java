package com.br.nice.util;


import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;


/***
 * 
 * @author cicinho
 *
 */
public class MsgFeedBackUser {

	
	/**
	 * message de sucesso para exibir no browser ao usuario final após uma operação de insert, update ou delete
	 * 
	 * @param message
	 */
	public static void AddmessageSuccess(String message) {
		FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, message, message);

		FacesContext facesContext = FacesContext.getCurrentInstance();

		ExternalContext externalContext = facesContext.getExternalContext();
		Flash flash = externalContext.getFlash();
		flash.setKeepMessages(true);

		facesContext.addMessage(null, facesMessage);
	}

	/**
	 * message de erro para exibir no browser ao usuario final após uma operação de insert, update ou delete Lembrando que aqui ele reportará a exeção
	 * 
	 * @author Pablo Henrique
	 * @param message
	 */
	public static void AddmessageError(String message) {
		FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message);

		FacesContext facesContext = FacesContext.getCurrentInstance();

		ExternalContext externalContext = facesContext.getExternalContext();
		Flash flash = externalContext.getFlash();
		flash.setKeepMessages(true);

		facesContext.addMessage(null, facesMessage);
	}
	
	public static void AddmessageAtention(String message) {
		FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_WARN, message, message);

		FacesContext facesContext = FacesContext.getCurrentInstance();

		ExternalContext externalContext = facesContext.getExternalContext();
		Flash flash = externalContext.getFlash();
		flash.setKeepMessages(true);

		facesContext.addMessage(null, facesMessage);
	}

	public static String getParam(String nome) {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		ExternalContext externalContext = facesContext.getExternalContext();

		Map<String, String> parametros = externalContext.getRequestParameterMap();
		String valor = parametros.get(nome);
		return valor;
	}
}
