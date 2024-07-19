package com.portale_cy.controller.valuta;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "DeleteAllValuteResponse", namespace = "http://fatture.portale_cy.com/")
@XmlAccessorType(XmlAccessType.FIELD)
public class DeleteAllValuteResponse {
	@XmlElement
	private String message;

	@XmlElement
	private int statusCode;

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
		return "DeleteAllValuteResponse [message=" + message + ", statusCode=" + statusCode + "]";
	}
}
