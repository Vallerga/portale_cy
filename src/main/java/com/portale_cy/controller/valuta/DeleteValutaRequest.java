package com.portale_cy.controller.valuta;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "DeleteValutaRequest", namespace = "http://fatture.portale_cy.com/")
@XmlAccessorType(XmlAccessType.FIELD)
public class DeleteValutaRequest {

	public DeleteValutaRequest() {
	}

	public DeleteValutaRequest(Long valutaId) {
		this.valutaId = valutaId;
	}

	@XmlElement(name = "valutaId", required = true, namespace = "http://fatture.portale_cy.com/")
	private Long valutaId;

	public Long getValutaId() {
		return valutaId;
	}

	public void setValutaId(Long valutaId) {
		this.valutaId = valutaId;
	}
}
