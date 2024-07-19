package com.portale_cy.controller.fattura;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "DeleteFatturaRequest", namespace = "http://fatture.portale_cy.com/")
@XmlAccessorType(XmlAccessType.FIELD)
public class DeleteFatturaRequest {

	public DeleteFatturaRequest() {
	}
	
	public DeleteFatturaRequest(Long id) {
		this.id = id;
	}	
	
	@XmlElement(name = "id", required = true, namespace = "http://fatture.portale_cy.com/")
	private Long id;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
