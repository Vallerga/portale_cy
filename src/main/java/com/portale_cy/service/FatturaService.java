package com.portale_cy.service;

import java.io.InputStream;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.portale_cy.db.model.Fattura;
import com.portale_cy.db.repository.FatturaDaoRepository;

@Service
public class FatturaService {
	private static final String ANNO = "anno";
	private static final String VALUTA = "valuta";
	private static final String PAESE = "paese";

	private final FatturaDaoRepository fatturaDao;
	private final ValutaService valutaService;

	public FatturaService(FatturaDaoRepository fatturaDao, ValutaService valutaService) {
		this.fatturaDao = fatturaDao;
		this.valutaService = valutaService;
	}

	public void insertFattura(Fattura fattura) {
		fatturaDao.save(fattura);
	}

	public Boolean updateFattura(Fattura fattura) {
		Boolean result = false;

		fatturaDao.save(fattura);
		result = true;

		return result;
	}

	public Fattura getFatturaById(Long id) {
		return fatturaDao.findById(id).orElse(null);
	}

	public List<Fattura> getAllFatture() {
		return (List<Fattura>) fatturaDao.findAll();
	}

	public Boolean deleteFatturaById(Long id) {
		Boolean result = false;

		fatturaDao.deleteById(id);
		result = true;

		return result;
	}

	public void deleteAllFatture() {
		fatturaDao.deleteAll();
	}

	public List<Fattura> loadFattura() {
		List<Fattura> result = null;
		InputStream fatturaInputStream = getClass().getClassLoader().getResourceAsStream("json/fatturaSample.json");

		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new JavaTimeModule());

		try {
			result = mapper.readValue(fatturaInputStream, new TypeReference<List<Fattura>>() {
			});

			for (Fattura fatt : result) {
				updateFattura(fatt);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}