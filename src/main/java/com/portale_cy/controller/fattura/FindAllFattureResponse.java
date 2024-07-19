package com.portale_cy.controller.fattura;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.portale_cy.db.model.Fattura;

@XmlRootElement(name = "FindAllFattureResponse", namespace = "http://fatture.portale_cy.com/")
@XmlAccessorType(XmlAccessType.FIELD)
public class FindAllFattureResponse {

	@XmlElement
	private int statusCode;

	@XmlElement(name = "fatture")
	private List<Fattura> fatture;

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public List<Fattura> getFatture() {
		return fatture;
	}

	public void setFatture(List<Fattura> fatture) {
		this.fatture = fatture;
	}

	@Override
	public String toString() {
		return "FindAllFattureResponse [statusCode=" + statusCode + ", fatture=" + fatture + "]";
	}
}
