package com.portale_cy.db.model;

public class GroupedEntry {
	private String groupBy;
	private String groupValue;
	private Double amount;
	private Integer numInvoice;

	public String getGroupBy() {
		return groupBy;
	}

	public void setGroupBy(String groupBy) {
		this.groupBy = groupBy;
	}

	public String getGroupValue() {
		return groupValue;
	}

	public void setGroupValue(String groupValue) {
		this.groupValue = groupValue;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Integer getNumInvoice() {
		return numInvoice;
	}

	public void setNumInvoice(Integer numInvoice) {
		this.numInvoice = numInvoice;
	}

	@Override
	public String toString() {
		return "GroupedEntry [groupBy=" + groupBy + ", groupValue=" + groupValue + ", amount=" + amount + ", numInvoice="
				+ numInvoice + "]";
	}
}
