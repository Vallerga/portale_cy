package com.portale_cy.db.model;

import java.util.Date;


public class FilteredEntry {
	private String number;
	private Integer invoiceYear;
	private Date data;
	private Double amount;
	private String currency;
	private String description;
	private String country;
	
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Integer getInvoiceYear() {
		return invoiceYear;
	}

	public void setInvoiceYear(Integer invoiceYear) {
		this.invoiceYear = invoiceYear;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "FilteredEntry [number=" + number + ", invoiceYear=" + invoiceYear + ", data=" + data + ", amount="
				+ amount + ", currency=" + currency + ", description=" + description + ", country=" + country + "]";
	}
}
