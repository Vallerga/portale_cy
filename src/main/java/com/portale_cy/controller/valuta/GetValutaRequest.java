package com.portale_cy.controller.valuta;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "GetValutaRequest", namespace = "http://fatture.portale_cy.com/")
@XmlAccessorType(XmlAccessType.FIELD)
public class GetValutaRequest {
	public GetValutaRequest() {
	}

	public GetValutaRequest(Long valutaid) {
		this.valutaid = valutaid;
	}

	@XmlElement(name = "valutaid", required = true, namespace = "http://fatture.portale_cy.com/")
	private Long valutaid;

	public Long getValutaid() {
		return valutaid;
	}

	public void setValutaid(Long valutaid) {
		this.valutaid = valutaid;
	}
}
