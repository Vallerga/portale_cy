package com.portale_cy.service.builder;

import java.util.Date;

import com.portale_cy.db.model.FilteredEntry;

public class FilteredEntriesBuilder {
	private String numero;
	private Date data;
	private String anno;
	private Double importo;
	private String valuta;
	private String paese;
	private String descrizione;

	public FilteredEntriesBuilder setNumero(String numero) {
		this.numero = numero;
		return this;
	}

	public FilteredEntriesBuilder setData(Date data) {
		this.data = data;
		return this;
	}

	public FilteredEntriesBuilder setAnno(String anno) {
		this.anno = anno;
		return this;
	}

	public FilteredEntriesBuilder setImporto(Double importo) {
		this.importo = importo;
		return this;
	}

	public FilteredEntriesBuilder setValuta(String valuta) {
		this.valuta = valuta;
		return this;
	}

	public FilteredEntriesBuilder setPaese(String paese) {
		this.paese = paese;
		return this;
	}

	public FilteredEntriesBuilder setDescrizione(String descrizione) {
		this.descrizione = descrizione;
		return this;
	}

	public FilteredEntry build() {
		FilteredEntry newFilteredEntry = new FilteredEntry();

		newFilteredEntry.setNumero(numero);
		newFilteredEntry.setData(data);
		newFilteredEntry.setAnno(anno);
		newFilteredEntry.setImporto(importo);
		newFilteredEntry.setValuta(valuta);
		newFilteredEntry.setPaese(paese);
		newFilteredEntry.setDescrizione(descrizione);

		return newFilteredEntry;
	}
}