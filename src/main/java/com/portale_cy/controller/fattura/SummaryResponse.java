package com.portale_cy.controller.fattura;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.portale_cy.db.model.FilteredEntry;
import com.portale_cy.db.model.GroupedEntry;

@XmlRootElement(name = "SummaryResponse", namespace = "http://fatture.portale_cy.com/")
@XmlAccessorType(XmlAccessType.FIELD)
public class SummaryResponse {
	private List<FilteredEntry> filteredEntries;
	private List<GroupedEntry> groupedEntries;

	public List<FilteredEntry> getFilteredEntries() {
		return filteredEntries;
	}

	public void setFilteredEntries(List<FilteredEntry> filteredEntries) {
		this.filteredEntries = filteredEntries;
	}

	public List<GroupedEntry> getGroupedEntries() {
		return groupedEntries;
	}

	public void setGroupedEntries(List<GroupedEntry> groupedEntries) {
		this.groupedEntries = groupedEntries;
	}

	@Override
	public String toString() {
		return "SummaryResponse [filteredEntries=" + filteredEntries + ", groupedEntries=" + groupedEntries + "]";
	}
}
