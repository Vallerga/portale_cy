package com.portale_cy.service;

import java.io.InputStream;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.portale_cy.db.model.Valuta;
import com.portale_cy.db.repository.ValutaDaoRepository;

@Service
public class ValutaService {

	private final ValutaDaoRepository valutaDao;

	public ValutaService(ValutaDaoRepository valutaDao) {
		this.valutaDao = valutaDao;
	}

	public void insertValuta(Valuta valuta) {
		valutaDao.save(valuta);
	}

	public Boolean updateValuta(Valuta valuta) {
		Boolean result = false;

		valutaDao.save(valuta);
		result = true;

		return result;
	}

	public Valuta getValutaById(Long id) {
		return valutaDao.findById(id).orElse(null);
	}

	public List<Valuta> getAllValute() {
		return (List<Valuta>) valutaDao.findAll();
	}

	public Boolean deleteValutaById(Long id) {
		Boolean result = false;

		valutaDao.deleteById(id);
		result = true;

		return result;
	}

	public void deleteAllValute() {
		valutaDao.deleteAll();
	}
	
	public List<Valuta> loadValuta() {
		List<Valuta> result = null;

		InputStream valutaInputStream = getClass().getClassLoader()
				.getResourceAsStream("json/valutaSample.json");

		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new JavaTimeModule());

		try {
			result = mapper.readValue(valutaInputStream,
					new TypeReference<List<Valuta>>() {
					});

			for (Valuta valuta : result) {
				updateValuta(valuta);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}