package com.portale_cy.controller.valuta;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.portale_cy.db.model.Valuta;

@XmlRootElement(name = "FindAllValuteResponse", namespace = "http://fatture.portale_cy.com/")
@XmlAccessorType(XmlAccessType.FIELD)
public class FindAllValuteResponse {

	@XmlElement
	private int statusCode;

	@XmlElement(name = "valute")
	private List<Valuta> valute;

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public List<Valuta> getValute() {
		return valute;
	}

	public void setValute(List<Valuta> valute) {
		this.valute = valute;
	}

	@Override
	public String toString() {
		return "FindAllValuteResponse [statusCode=" + statusCode + ", valute=" + valute + "]";
	}
}
