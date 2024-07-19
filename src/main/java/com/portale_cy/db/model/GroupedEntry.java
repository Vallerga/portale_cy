package com.portale_cy.db.model;

public class GroupedEntry {
	private String raggruppatoDa;
	private String valoreRaggruppamento;
	private Double importo;
	private Integer numFatture;

	public String getRaggruppatoDa() {
		return raggruppatoDa;
	}

	public GroupedEntry(String raggruppatoDa, String valoreRaggruppamento, Double importo, Integer numFatture) {
		this.raggruppatoDa = raggruppatoDa;
		this.valoreRaggruppamento = valoreRaggruppamento;
		this.importo = importo;
		this.numFatture = numFatture;
	}

	public void setRaggruppatoDa(String raggruppatoDa) {
		this.raggruppatoDa = raggruppatoDa;
	}

	public String getValoreRaggruppamento() {
		return valoreRaggruppamento;
	}

	public void setValoreRaggruppamento(String valoreRaggruppamento) {
		this.valoreRaggruppamento = valoreRaggruppamento;
	}

	public Double getImporto() {
		return importo;
	}

	public void setImporto(Double importo) {
		this.importo = importo;
	}

	public Integer getNumFatture() {
		return numFatture;
	}

	public void setNumFatture(Integer numFatture) {
		this.numFatture = numFatture;
	}

	@Override
	public String toString() {
		return "GroupedEntry [raggruppatoDa=" + raggruppatoDa + ", valoreRaggruppamento=" + valoreRaggruppamento
				+ ", importo=" + importo + ", numFatture=" + numFatture + "]";
	}
}
