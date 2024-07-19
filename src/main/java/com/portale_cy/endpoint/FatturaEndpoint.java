package com.portale_cy.endpoint;

import java.util.List;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.portale_cy.controller.fattura.CreateFatturaRequest;
import com.portale_cy.controller.fattura.CreateFatturaResponse;
import com.portale_cy.controller.fattura.DeleteAllFattureRequest;
import com.portale_cy.controller.fattura.DeleteAllFattureResponse;
import com.portale_cy.controller.fattura.DeleteFatturaRequest;
import com.portale_cy.controller.fattura.DeleteFatturaResponse;
import com.portale_cy.controller.fattura.FindAllFattureRequest;
import com.portale_cy.controller.fattura.FindAllFattureResponse;
import com.portale_cy.controller.fattura.GetFatturaRequest;
import com.portale_cy.controller.fattura.GetFatturaResponse;
import com.portale_cy.controller.fattura.LoadDataRequest;
import com.portale_cy.controller.fattura.LoadDataResponse;
import com.portale_cy.controller.fattura.PutFatturaRequest;
import com.portale_cy.controller.fattura.PutFatturaResponse;
import com.portale_cy.db.model.Fattura;
import com.portale_cy.db.model.Valuta;
import com.portale_cy.service.FatturaService;
import com.portale_cy.service.ValutaService;

@Endpoint
public class FatturaEndpoint {

	private static final String NAMESPACE_URI = "http://fatture.portale_cy.com/";

	private FatturaService fatturaService;
	private ValutaService valutaService;

	public FatturaEndpoint(FatturaService fatturaService, ValutaService valutaService) {
		this.fatturaService = fatturaService;
		this.valutaService = valutaService;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "TestConnectionFatturaRequest")
	@ResponsePayload
	public JAXBElement<String> testConnection(@RequestPayload JAXBElement<String> testRequest) {
		String response = testRequest.getValue();
		return new JAXBElement<>(new QName(NAMESPACE_URI, "TestConnectionResponse"), String.class, response);
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "CreateFatturaRequest")
	@ResponsePayload
	public CreateFatturaResponse createFattura(@RequestPayload CreateFatturaRequest request) {
		Fattura fattura = new Fattura();
		fattura.setNumero(request.getNumero());
		fattura.setData(request.getData());
		fattura.setAnno(request.getAnno());
		fattura.setImporto(request.getImporto());
		fattura.setValuta(request.getValuta());
		fattura.setPaese(request.getPaese());
		fattura.setDescrizione(request.getDescrizione());

		fatturaService.insertFattura(fattura);

		CreateFatturaResponse response = new CreateFatturaResponse();
		response.setFattura(fattura);
		response.setMessage("Fattura created successfully");
		response.setStatusCode(200);

		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetFatturaRequest")
	@ResponsePayload
	public GetFatturaResponse getFattura(@RequestPayload GetFatturaRequest request) {
		GetFatturaResponse response = new GetFatturaResponse();
		response.setFattura(fatturaService.getFatturaById(request.getId()));

		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "DeleteFatturaRequest")
	@ResponsePayload
	public DeleteFatturaResponse deleteFattura(@RequestPayload DeleteFatturaRequest request) {
		boolean success = fatturaService.deleteFatturaById(request.getId());

		DeleteFatturaResponse response = new DeleteFatturaResponse();
		response.setMessage("Fattura deleted successfully");
		response.setSuccess(success);
		response.setStatusCode(200);

		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "PutFatturaRequest")
	@ResponsePayload
	public PutFatturaResponse putFattura(@RequestPayload PutFatturaRequest request) {

		Fattura fattura = new Fattura();
		fattura.setFatturaId(request.getFatturaId());
		fattura.setNumero(request.getNumero());
		fattura.setData(request.getData());
		fattura.setAnno(request.getAnno());
		fattura.setImporto(request.getImporto());
		fattura.setValuta(request.getValuta());
		fattura.setPaese(request.getPaese());
		fattura.setDescrizione(request.getDescrizione());

		boolean success = fatturaService.updateFattura(fattura);

		PutFatturaResponse response = new PutFatturaResponse();
		response.setFattura(fattura);
		response.setMessage("Fattura updated successfully");
		response.setSuccess(success);
		response.setStatusCode(200);

		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "FindAllFattureRequest")
	@ResponsePayload
	public FindAllFattureResponse findAllFatture(@RequestPayload FindAllFattureRequest findAllFattureRequest) {
		List<Fattura> fattureList = fatturaService.getAllFatture();

		FindAllFattureResponse response = new FindAllFattureResponse();
		response.setFatture(fattureList);
		response.setStatusCode(200);

		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "DeleteAllFattureRequest")
	@ResponsePayload
	public DeleteAllFattureResponse deleteAllFatture(@RequestPayload DeleteAllFattureRequest deleteAllFattureRequest) {
		fatturaService.deleteAllFatture();

		DeleteAllFattureResponse response = new DeleteAllFattureResponse();
		response.setMessage("All Fatture Removed successfully");
		response.setStatusCode(200);

		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "LoadDataRequest")
	@ResponsePayload
	public LoadDataResponse loadData(@RequestPayload LoadDataRequest loadDataRequest) {
		List<Fattura> fatturaList = fatturaService.loadFattura();
		List<Valuta> valutaList = valutaService.loadValuta();

		LoadDataResponse response = new LoadDataResponse();
		response.setFatture(fatturaList);
		response.setValute(valutaList);
		response.setStatusCode(200);

		return response;
	}
}