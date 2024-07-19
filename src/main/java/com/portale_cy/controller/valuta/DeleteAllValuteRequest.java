package com.portale_cy.controller.valuta;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "DeleteAllValuteRequest", namespace = "http://fatture.portale_cy.com/")
@XmlAccessorType(XmlAccessType.FIELD)
public class DeleteAllValuteRequest {
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
		return "DeleteAllValuteRequest [messagge=" + messagge + "]";
	}
}
