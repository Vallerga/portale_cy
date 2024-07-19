package com.portale_cy.controller.valuta;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.portale_cy.db.model.Valuta;

@XmlRootElement(name = "CreateValutaResponse", namespace = "http://fatture.portale_cy.com/")
@XmlAccessorType(XmlAccessType.FIELD)
public class CreateValutaResponse {
	@XmlElement(required = true)
	private Valuta valuta;

	@XmlElement
	private String message;

	@XmlElement
	private int statusCode;

	public Valuta getValuta() {
		return valuta;
	}

	public void setValuta(Valuta valuta) {
		this.valuta = valuta;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	@Override
	public String toString() {
		return "CreateCambioValutaResponse [valuta=" + valuta + ", message=" + message + ", statusCode="
				+ statusCode + "]";
	}
}
