package com.cct.restful.wsservice.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class ClientFormParams {
	
	private static String REST_URI_FORM = "http://127.0.0.1:8080/RESTfulDemo/rest/travellerServiceWSForm";	
	private static Client client = ClientBuilder.newClient();

	public static void main(String[] args) throws Exception {

		System.out.println("");
		System.out.println("1 : ######################");
		System.out.println("");
		
		Form form = new Form();
		form.param("id", "1");
		form.param("name", "Chalach");
		
		Response response = client.target(REST_URI_FORM).path("/addTraveller").request(MediaType.APPLICATION_JSON).post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED_TYPE));

		System.out.println(response.getStatus());
		System.out.println(response.getEntity().toString());
	}
	
}
