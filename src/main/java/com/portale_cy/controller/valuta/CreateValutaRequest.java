package com.portale_cy.controller.valuta;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "CreateValutaRequest", namespace = "http://fatture.portale_cy.com/")
@XmlAccessorType(XmlAccessType.FIELD)
public class CreateValutaRequest {
	@XmlElement(name = "valutaPrincipale", required = true, namespace = "http://fatture.portale_cy.com/")
	private String valutaPrincipale;

	@XmlElement(name = "cambioEUR", required = true, namespace = "http://fatture.portale_cy.com/")
	private Double cambioEUR;

	@XmlElement(name = "cambioUSD", required = true, namespace = "http://fatture.portale_cy.com/")
	private Double cambioUSD;

	@XmlElement(name = "cambioGBD", required = true, namespace = "http://fatture.portale_cy.com/")
	private Double cambioGBD;

	public String getValutaPrincipale() {
		return valutaPrincipale;
	}

	public void setValutaPrincipale(String valutaPrincipale) {
		this.valutaPrincipale = valutaPrincipale;
	}

	public Double getCambioEUR() {
		return cambioEUR;
	}

	public void setCambioEUR(Double cambioEUR) {
		this.cambioEUR = cambioEUR;
	}

	public Double getCambioUSD() {
		return cambioUSD;
	}

	public void setCambioUSD(Double cambioUSD) {
		this.cambioUSD = cambioUSD;
	}

	public Double getCambioGBD() {
		return cambioGBD;
	}

	public void setCambioGBD(Double cambioGBD) {
		this.cambioGBD = cambioGBD;
	}

	@Override
	public String toString() {
		return "CreateValutaRequest [valutaPrincipale=" + valutaPrincipale + ", cambioEUR=" + cambioEUR + ", cambioUSD="
				+ cambioUSD + ", cambioGBD=" + cambioGBD + "]";
	}
}
