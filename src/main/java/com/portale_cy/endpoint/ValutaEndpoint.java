package com.portale_cy.endpoint;

import java.util.List;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.portale_cy.controller.valuta.CreateValutaRequest;
import com.portale_cy.controller.valuta.CreateValutaResponse;
import com.portale_cy.controller.valuta.DeleteAllValuteRequest;
import com.portale_cy.controller.valuta.DeleteAllValuteResponse;
import com.portale_cy.controller.valuta.DeleteValutaRequest;
import com.portale_cy.controller.valuta.DeleteValutaResponse;
import com.portale_cy.controller.valuta.FindAllValuteRequest;
import com.portale_cy.controller.valuta.FindAllValuteResponse;
import com.portale_cy.controller.valuta.GetValutaRequest;
import com.portale_cy.controller.valuta.GetValutaResponse;
import com.portale_cy.controller.valuta.PutValutaRequest;
import com.portale_cy.controller.valuta.PutValutaResponse;
import com.portale_cy.db.model.Valuta;
import com.portale_cy.service.ValutaService;

@Endpoint
public class ValutaEndpoint {

	private static final String NAMESPACE_URI = "http://fatture.portale_cy.com/";

	private ValutaService valutaService;

	public ValutaEndpoint(ValutaService valutaService) {
		this.valutaService = valutaService;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "TestConnectionValutaRequest")
	@ResponsePayload
	public JAXBElement<String> testConnection(@RequestPayload JAXBElement<String> testRequest) {
		String response = testRequest.getValue();
		return new JAXBElement<>(new QName(NAMESPACE_URI, "TestConnectionResponse"), String.class, response);
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "CreateValutaRequest")
	@ResponsePayload
	public CreateValutaResponse createValuta(@RequestPayload CreateValutaRequest createRequest) {
		Valuta valuta = new Valuta();
		valuta.setValutaPrincipale(createRequest.getValutaPrincipale());
		valuta.setCambioEUR(createRequest.getCambioEUR());
		valuta.setCambioUSD(createRequest.getCambioUSD());
		valuta.setCambioGBD(createRequest.getCambioGBD());

		valutaService.insertValuta(valuta);

		CreateValutaResponse response = new CreateValutaResponse();
		response.setValuta(valuta);
		response.setMessage("valuta created successfully");
		response.setStatusCode(200);

		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetValutaRequest")
	@ResponsePayload
	public GetValutaResponse getValuta(@RequestPayload GetValutaRequest getRequest) {
		GetValutaResponse response = new GetValutaResponse();
		response.setValuta(valutaService.getValutaById(getRequest.getValutaid()));

		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "DeleteValutaRequest")
	@ResponsePayload
	public DeleteValutaResponse deleteValuta(@RequestPayload DeleteValutaRequest removeRequest) {
		boolean success = valutaService.deleteValutaById(removeRequest.getValutaId());

		DeleteValutaResponse response = new DeleteValutaResponse();
		response.setMessage("Valuta deleted successfully");
		response.setSuccess(success);
		response.setStatusCode(200);

		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "PutValutaRequest")
	@ResponsePayload
	public PutValutaResponse putValuta(@RequestPayload PutValutaRequest PutRequest) {

		Valuta valuta = new Valuta();
		valuta.setValutaId(PutRequest.getValutaId());
		valuta.setValutaPrincipale(PutRequest.getValutaPrincipale());
		valuta.setCambioEUR(PutRequest.getCambioEUR());
		valuta.setCambioUSD(PutRequest.getCambioUSD());
		valuta.setCambioGBD(PutRequest.getCambioGBD());

		boolean success = valutaService.updateValuta(valuta);

		PutValutaResponse response = new PutValutaResponse();
		response.setValuta(valuta);
		response.setMessage("Valuta updated successfully");
		response.setSuccess(success);
		response.setStatusCode(200);

		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "FindAllValuteRequest")
	@ResponsePayload
	public FindAllValuteResponse findAllValute(@RequestPayload FindAllValuteRequest findAllValuteRequest) {
		List<Valuta> valuteList = valutaService.getAllValute();

		FindAllValuteResponse response = new FindAllValuteResponse();
		response.setValute(valuteList);
		response.setStatusCode(200);

		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "DeleteAllValuteRequest")
	@ResponsePayload
	public DeleteAllValuteResponse removeAllValute(@RequestPayload DeleteAllValuteRequest deleteAllValuteRequest) {
		valutaService.deleteAllValute();

		DeleteAllValuteResponse response = new DeleteAllValuteResponse();
		response.setMessage("All Valute Removed successfully");
		response.setStatusCode(200);

		return response;
	}
}