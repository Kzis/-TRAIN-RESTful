package com.cct.restful.wsservice.client;


import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.cct.restful.wsservice.domain.Traveller;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ClientPastParams {
	
	private static String REST_URI = "http://127.0.0.1:8081/RESTfulDemo/rest/travellerServiceWSPath";
	private static Client client = ClientBuilder.newClient();

	
	public static void main(String[] args) throws Exception {
		
		ObjectMapper mapper = new ObjectMapper();
		
		System.out.println("");
		System.out.println("1 : ######################");
		System.out.println("");
		
//		//แบบที่ 1 :Passing Single Path Parameter
		Traveller tr = client.target(REST_URI).path("/getTravellerByIdPath").path(String.valueOf("1")).request(MediaType.APPLICATION_JSON).get(Traveller.class);
		System.out.println("Response for getAllTraveller : " + tr.getFirstName());
		System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(tr));
		System.out.println(mapper.writeValueAsString(tr));
		
		System.out.println("");
		System.out.println("2 : ######################");
		System.out.println("");
		
		//แบบที่ 2 :Passing Multiple Path Parameters แยก URI
		Traveller tr2 = client.target(REST_URI).path("/getTravellerByIdPath2").path(String.valueOf("1")).path("NAME NAME").request(MediaType.APPLICATION_JSON).get(Traveller.class);
		System.out.println("Response for getAllTraveller : " + tr2.getFirstName());
		System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(tr2));
		System.out.println(mapper.writeValueAsString(tr2));
		
		System.out.println("");
		System.out.println("3 : ######################");
		System.out.println("");
		
		//แบบที่ 3 :Passing Multiple Path Parameters IN ONE URI
		Traveller tr4 = client.target(REST_URI).path("/getTravellerByIdPath4").path(String.valueOf("1")+"-NAME NAME").request(MediaType.APPLICATION_JSON).get(Traveller.class);
		System.out.println("Response for getAllTraveller : " + tr4.getFirstName());
		System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(tr4));
		System.out.println(mapper.writeValueAsString(tr4));
		
		System.out.println("");
		System.out.println("4 : ######################");
		System.out.println("");
		
		//แบบที่ 4 :Retrieve Path Information using the UriInfo class
		Traveller tr3 = client.target(REST_URI).path("/getTravellerByIdPath3").path(String.valueOf("1")).request(MediaType.APPLICATION_JSON).get(Traveller.class);
		System.out.println("Response for getAllTraveller : " + tr3.getFirstName());
		System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(tr3));
		System.out.println(mapper.writeValueAsString(tr3));
				
	}
	

}
