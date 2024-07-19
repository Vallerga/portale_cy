package com.portale_cy.db.model;

import java.util.Date;

public class FilteredEntry {
	private String numero;
	private Date data;
	private String anno;
	private Double importo;
	private String valuta;
	private String paese;
	private String descrizione;

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getAnno() {
		return anno;
	}

	public void setAnno(String anno) {
		this.anno = anno;
	}

	public Double getImporto() {
		return importo;
	}

	public void setImporto(Double importo) {
		this.importo = importo;
	}

	public String getValuta() {
		return valuta;
	}

	public void setValuta(String valuta) {
		this.valuta = valuta;
	}

	public String getPaese() {
		return paese;
	}

	public void setPaese(String paese) {
		this.paese = paese;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	@Override
	public String toString() {
		return "FilteredEntry [numero=" + numero + ", data=" + data + ", anno=" + anno + ", importo=" + importo
				+ ", valuta=" + valuta + ", paese=" + paese + ", descrizione=" + descrizione + "]";
	}
}
