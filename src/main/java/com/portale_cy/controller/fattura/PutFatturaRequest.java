package com.portale_cy.controller.fattura;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "PutFatturaRequest", namespace = "http://fatture.portale_cy.com/")
@XmlAccessorType(XmlAccessType.FIELD)
public class PutFatturaRequest {

	@XmlElement(name = "fatturaId", required = true, namespace = "http://fatture.portale_cy.com/")
	private Long fatturaId;

	@XmlElement(name = "numero", required = true, namespace = "http://fatture.portale_cy.com/")
	private String numero;

	@XmlElement(name = "data", required = true, namespace = "http://fatture.portale_cy.com/")
	private Date data;
	
	@XmlElement(name = "anno", required = true, namespace = "http://fatture.portale_cy.com/")
	private String anno;

	@XmlElement(name = "importo", required = true, namespace = "http://fatture.portale_cy.com/")
	private double importo;

	@XmlElement(name = "valuta", required = true, namespace = "http://fatture.portale_cy.com/")
	private String valuta;

	@XmlElement(name = "paese", required = true, namespace = "http://fatture.portale_cy.com/")
	private String paese;

	@XmlElement(name = "descrizione", required = true, namespace = "http://fatture.portale_cy.com/")
	private String descrizione;

	public Long getFatturaId() {
		return fatturaId;
	}

	public void setFatturaId(Long fatturaId) {
		this.fatturaId = fatturaId;
	}

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

	public double getImporto() {
		return importo;
	}

	public void setImporto(double importo) {
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
		return "PutFatturaRequest [fatturaId=" + fatturaId + ", numero=" + numero + ", data=" + data + ", anno=" + anno
				+ ", importo=" + importo + ", valuta=" + valuta + ", paese=" + paese + ", descrizione=" + descrizione
				+ "]";
	}
}
