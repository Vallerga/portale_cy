package com.portale_cy.service.builder;

import java.util.Date;

import com.portale_cy.db.model.Fattura;

public class FatturaBuilder {
	private Long fatturaId;
	private String numero;
	private Date data;
	private String anno;
	private Double importo;
	private String valuta;
	private String paese;
	private String descrizione;

	public FatturaBuilder setFatturaId(Long fatturaId) {
		this.fatturaId = fatturaId;
		return this;
	}
	
	public FatturaBuilder setNumero(String numero) {
		this.numero = numero;
		return this;
	}

	public FatturaBuilder setData(Date data) {
		this.data = data;
		return this;
	}

	public FatturaBuilder setAnno(String anno) {
		this.anno = anno;
		return this;
	}

	public FatturaBuilder setImporto(Double importo) {
		this.importo = importo;
		return this;
	}

	public FatturaBuilder setValuta(String valuta) {
		this.valuta = valuta;
		return this;
	}

	public FatturaBuilder setPaese(String paese) {
		this.paese = paese;
		return this;
	}

	public FatturaBuilder setDescrizione(String descrizione) {
		this.descrizione = descrizione;
		return this;
	}

	public Fattura build() {
		Fattura newFattura = new Fattura();

		newFattura.setFatturaId(fatturaId);
		newFattura.setNumero(numero);
		newFattura.setData(data);
		newFattura.setAnno(anno);
		newFattura.setImporto(importo);
		newFattura.setValuta(valuta);
		newFattura.setPaese(paese);
		newFattura.setDescrizione(descrizione);

		return newFattura;
	}
}