package com.portale_cy.controller.valuta;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.portale_cy.db.model.Valuta;

@XmlRootElement(name = "GetValutaResponse", namespace = "http://fatture.portale_cy.com/")
@XmlAccessorType(XmlAccessType.FIELD)
public class GetValutaResponse {

	public GetValutaResponse() {
	}

	public GetValutaResponse(Valuta valuta) {
		this.valuta = valuta;
	}

	@XmlElement(name = "valuta", required = true, namespace = "http://fatture.portale_cy.com/")
	private Valuta valuta;

	public Valuta getValuta() {
		return valuta;
	}

	public void setValuta(Valuta valuta) {
		this.valuta = valuta;
	}
}
