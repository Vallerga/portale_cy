package com.portale_cy.controller.fattura;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.portale_cy.db.model.Fattura;

@XmlRootElement(name = "GetFatturaResponse", namespace = "http://fatture.portale_cy.com/")
@XmlAccessorType(XmlAccessType.FIELD)
public class GetFatturaResponse {

	public GetFatturaResponse() {
	}

	public GetFatturaResponse(Fattura fattura) {
		this.fattura = fattura;
	}

	@XmlElement(required = true)
	private Fattura fattura;

	public Fattura getFattura() {
		return fattura;
	}

	public void setFattura(Fattura fattura) {
		this.fattura = fattura;
	}
}