package com.portale_cy.service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.portale_cy.db.model.Fattura;
import com.portale_cy.db.model.FilteredEntry;
import com.portale_cy.db.model.GroupedEntry;
import com.portale_cy.db.model.Valuta;
import com.portale_cy.db.repository.FatturaDaoRepository;
import com.portale_cy.service.builder.FatturaBuilder;
import com.portale_cy.service.builder.FilteredEntriesBuilder;

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

	public List<GroupedEntry> summaryGroupBy(String groupby, List<FilteredEntry> filteredEntries,
			String valutaSelected) {
		List<GroupedEntry> groupedEntries = null;
		List<Fattura> fattureList = new ArrayList<>();
		Boolean isPresentGroupBy = Optional.ofNullable(groupby).isPresent();
		System.out.println("groupby: " + groupby);
		if (groupby == null) {
			System.out.println("groupedEntries: " + groupedEntries);
			return groupedEntries;
		}
		if (filteredEntries != null && !filteredEntries.isEmpty()) {
			for (FilteredEntry filteredEntry : filteredEntries) {
				fattureList.add(new FatturaBuilder().setNumero(filteredEntry.getNumero())
						.setAnno(filteredEntry.getAnno()).setData(filteredEntry.getData())
						.setImporto(filteredEntry.getImporto()).setValuta(filteredEntry.getValuta())
						.setPaese(filteredEntry.getPaese()).setDescrizione(filteredEntry.getDescrizione()).build());
			}
			for (Fattura fat : fattureList) {
				System.out.println("IF: " + fat);
			}
		} else {
			fattureList = (List<Fattura>) fatturaDao.findAll();
			for (Fattura fat : fattureList) {
				System.out.println("ELSE: " + fat);
			}
		}

		if (Boolean.TRUE.equals(isPresentGroupBy)) {
			groupedEntries = groupBy(fattureList, groupby, valutaSelected);
		}

		return groupedEntries;
	}

	public List<FilteredEntry> summaryFilterBy(String filterby, String value) {
		Boolean isPresentFilterBy = Optional.ofNullable(filterby).isPresent();

		List<Fattura> fattureList = (List<Fattura>) fatturaDao.findAll();
		List<FilteredEntry> filteredEntries = new ArrayList<>();

		if (Boolean.TRUE.equals(isPresentFilterBy) && filterby.length() > 0 && value != null && value.length() > 0) {
			filteredEntries = filterBy(fattureList, filterby, value);

		} else {
			for (Fattura fattura : fattureList) {
				filteredEntries.add(new FilteredEntriesBuilder().setNumero(fattura.getNumero())
						.setAnno(fattura.getAnno()).setData(fattura.getData()).setImporto(fattura.getImporto())
						.setValuta(fattura.getValuta()).setPaese(fattura.getPaese())
						.setDescrizione(fattura.getDescrizione()).build());
			}
		}
		return filteredEntries;
	}

	private List<GroupedEntry> groupBy(List<Fattura> fattureList, String groupby, String valutaSelected) {
		List<GroupedEntry> groupedEntries = new ArrayList<>();

		List<Valuta> valuteList = valutaService.getAllValute();

		fattureList = valutaService.valutaConvertitor(valutaSelected, fattureList, valuteList);

		if (groupby.equals(ANNO)) {
			groupedEntries = fattureList.stream().collect(Collectors.groupingBy(Fattura::getAnno)).entrySet().stream()
					.map(entry -> {
						String anno = entry.getKey();
						List<Fattura> lista = entry.getValue();
						Double importo = lista.stream().mapToDouble(Fattura::getImporto).sum();
						Integer numFatture = lista.size();
						return new GroupedEntry(ANNO, anno, importo, numFatture);
					}).collect(Collectors.toList());
		}

		if (groupby.equals(PAESE)) {
			groupedEntries = fattureList.stream().collect(Collectors.groupingBy(Fattura::getPaese)).entrySet().stream()
					.map(entry -> {
						String paese = entry.getKey();
						List<Fattura> lista = entry.getValue();
						Double importo = lista.stream().mapToDouble(Fattura::getImporto).sum();
						Integer numInvoices = lista.size();
						return new GroupedEntry(PAESE, paese, importo, numInvoices);
					}).collect(Collectors.toList());
		}

		if (groupby.equals(VALUTA)) {
			groupedEntries = fattureList.stream().collect(Collectors.groupingBy(Fattura::getValuta)).entrySet().stream()
					.map(entry -> {
						String valuta = entry.getKey();
						List<Fattura> lista = entry.getValue();
						Double importo = lista.stream().mapToDouble(Fattura::getImporto).sum();
						Integer numInvoices = lista.size();
						return new GroupedEntry(VALUTA, String.valueOf(valuta), importo, numInvoices);
					}).collect(Collectors.toList());
		}
		return groupedEntries;
	}

	private List<FilteredEntry> filterBy(List<Fattura> fattureList, String filterby, String value) {
		List<FilteredEntry> filteredEntries = new ArrayList<>();

		if (filterby.equals(ANNO)) {
			Integer targetYear = Integer.valueOf(value);
			filteredEntries = fattureList.stream()
					.filter(fattura -> Integer.valueOf(fattura.getAnno()).equals(targetYear))
					.map(fattura -> new FilteredEntriesBuilder().setNumero(fattura.getNumero())
							.setAnno(fattura.getAnno()).setData(fattura.getData()).setImporto(fattura.getImporto())
							.setValuta(fattura.getValuta()).setPaese(fattura.getPaese())
							.setDescrizione(fattura.getDescrizione()).build())
					.collect(Collectors.toList());
		}
		if (filterby.equals(PAESE)) {
			filteredEntries = fattureList.stream().filter(fattura -> Objects.equals(fattura.getPaese(), value))
					.map(fattura -> new FilteredEntriesBuilder().setNumero(fattura.getNumero())
							.setAnno(fattura.getAnno()).setData(fattura.getData()).setImporto(fattura.getImporto())
							.setValuta(fattura.getValuta()).setPaese(fattura.getPaese())
							.setDescrizione(fattura.getDescrizione()).build())
					.collect(Collectors.toList());
		}

		if (filterby.equals(VALUTA)) {
			filteredEntries = fattureList.stream().filter(fattura -> Objects.equals(fattura.getValuta(), value))
					.map(fattura -> new FilteredEntriesBuilder().setNumero(fattura.getNumero())
							.setAnno(fattura.getAnno()).setData(fattura.getData()).setImporto(fattura.getImporto())
							.setValuta(fattura.getValuta()).setPaese(fattura.getPaese())
							.setDescrizione(fattura.getDescrizione()).build())
					.collect(Collectors.toList());
		}
		return filteredEntries;
	}
}