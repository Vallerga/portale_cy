package com.portale_cy.controller.fattura;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "SummaryRequest", namespace = "http://fatture.portale_cy.com/")
@XmlAccessorType(XmlAccessType.FIELD)
public class SummaryRequest {
	
	@XmlElement(name = "filterBy", required = true, namespace = "http://fatture.portale_cy.com/")
	private String filterBy;
	
	@XmlElement(name = "filterValue", required = true, namespace = "http://fatture.portale_cy.com/")
	private String filterValue;
	
	@XmlElement(name = "groupBy", required = true, namespace = "http://fatture.portale_cy.com/")
	private String groupBy;
	
	@XmlElement(name = "valutaSelected", required = true, namespace = "http://fatture.portale_cy.com/")
	private String valutaSelected;

	public String getFilterBy() {
		return filterBy;
	}

	public void setFilterBy(String filterBy) {
		this.filterBy = filterBy;
	}

	public String getFilterValue() {
		return filterValue;
	}

	public void setFilterValue(String filterValue) {
		this.filterValue = filterValue;
	}

	public String getGroupBy() {
		return groupBy;
	}

	public void setGroupBy(String groupBy) {
		this.groupBy = groupBy;
	}

	public String getValutaSelected() {
		return valutaSelected;
	}

	public void setValutaSelected(String valutaSelected) {
		this.valutaSelected = valutaSelected;
	}

	@Override
	public String toString() {
		return "SummaryRequest [filterBy=" + filterBy + ", filterValue=" + filterValue + ", groupBy=" + groupBy
				+ ", valutaSelected=" + valutaSelected + "]";
	}
}
