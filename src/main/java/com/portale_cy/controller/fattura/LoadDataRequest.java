package com.portale_cy.controller.fattura;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "LoadDataRequest", namespace = "http://fatture.portale_cy.com/")
@XmlAccessorType(XmlAccessType.FIELD)
public class LoadDataRequest {
	@XmlElement(name = "messagge")
	private String messagge;

	public String getMessagge() {
		return messagge;
	}

	public void setMessagge(String messagge) {
		this.messagge = messagge;
	}

	@Override
	public String toString() {
		return "LoadDataRequest [messagge=" + messagge + "]";
	}
}
