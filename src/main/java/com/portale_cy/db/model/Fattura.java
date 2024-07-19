package com.portale_cy.db.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "Fattura", namespace = "http://fatture.portale_cy.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "fatturaId", "numero", "data", "anno", "importo", "valuta", "paese", "descrizione" })
@Entity
public class Fattura {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@XmlElement(required = true)
	private Long fatturaId;

	@XmlElement(required = true)
	private String numero;

	@XmlElement(required = true)
	private Date data;
	
	@XmlElement(required = true)
	private String anno;

	@XmlElement(required = true)
	private Double importo;

	@XmlElement(required = true)
	private String valuta;

	@XmlElement(required = true)
	private String paese;

	@XmlElement(required = true)
	private String descrizione;

	// Getter e setter
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
		return "Fattura [fatturaId=" + fatturaId + ", numero=" + numero + ", data=" + data + ", anno=" + anno
				+ ", importo=" + importo + ", valuta=" + valuta + ", paese=" + paese + ", descrizione=" + descrizione
				+ "]";
	}
}