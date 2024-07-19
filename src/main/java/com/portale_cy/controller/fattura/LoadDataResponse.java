package com.portale_cy.controller.fattura;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.portale_cy.db.model.Fattura;
import com.portale_cy.db.model.Valuta;

@XmlRootElement(name = "LoadDataResponse", namespace = "http://fatture.portale_cy.com/")
@XmlAccessorType(XmlAccessType.FIELD)
public class LoadDataResponse {
	@XmlElement(name = "fatture")
	private List<Fattura> fatture;

	@XmlElement(name = "valute")
	private List<Valuta> valute;

	@XmlElement
	private int statusCode;

	public List<Fattura> getFatture() {
		return fatture;
	}

	public void setFatture(List<Fattura> fatture) {
		this.fatture = fatture;
	}

	public List<Valuta> getValute() {
		return valute;
	}

	public void setValute(List<Valuta> valute) {
		this.valute = valute;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	@Override
	public String toString() {
		return "LoadDataResponse [fatture=" + fatture + ", valute=" + valute + ", statusCode=" + statusCode + "]";
	}
}
