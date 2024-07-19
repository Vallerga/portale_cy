package com.portale_cy.db.model;

import java.util.List;

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
