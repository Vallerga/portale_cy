package com.portale_cy.db.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "Valuta", namespace = "http://fatture.portale_cy.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "valutaId", "valutaPrincipale", "cambioEUR", "cambioUSD", "cambioGBD" })
@Entity
public class Valuta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@XmlElement(required = true)
	private Long valutaId;

	@XmlElement(required = true)
	private String valutaPrincipale;

	@XmlElement(required = true)
	private Double cambioEUR;

	@XmlElement(required = true)
	private Double cambioUSD;

	@XmlElement(required = true)
	private Double cambioGBD;

	public Long getValutaId() {
		return valutaId;
	}

	public void setValutaId(Long valutaId) {
		this.valutaId = valutaId;
	}

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
		return "Valuta [valutaId=" + valutaId + ", valutaPrincipale=" + valutaPrincipale + ", cambioEUR=" + cambioEUR
				+ ", cambioUSD=" + cambioUSD + ", cambioGBD=" + cambioGBD + "]";
	}
}
