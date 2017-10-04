package com.cct.restful.wsservice.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.catalina.mapper.Mapper;

import com.cct.restful.wsservice.domain.Traveller;
import com.cct.restful.wsservice.domain.TravellerChalach;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ClientTest {

	private static String REST_URI = "http://127.0.0.1:8081/RESTfulDemo/rest/travellerServiceWS";
	private static Client client = ClientBuilder.newClient();
	
	public static void main(String[] args) throws Exception {
		
		TravellerChalach tra = new TravellerChalach();
		tra.setX("xxx");
		tra.setY("yyy");
		
//		Response response = client.target(REST_URI).path("/getTraveller").request(MediaType.APPLICATION_JSON).get();
//		System.out.println("Response for getAllTraveller : " + response.getStatus());
		
//		Response response = client.target(REST_URI).path("/getXML").request(MediaType.APPLICATION_JSON).get();
//		System.out.println("Response for getAllTraveller : " + response.getStatus());
		
		//POST Object Null
//		Response response = client.target(REST_URI).path("/getTestPost").request(MediaType.APPLICATION_JSON).post(Entity.entity(null, MediaType.APPLICATION_JSON));
//		System.out.println("Response for getAllTraveller : " + response.getStatus());
		
		//POST Object Traveller
//		Response response = client.target(REST_URI).path("/getTestPost").request(MediaType.APPLICATION_JSON).post(Entity.entity(tra, MediaType.APPLICATION_JSON));
//		System.out.println("Response for getAllTraveller : " + response.getStatus());
//		
		//POST(Client JSON , WS Consume XML) Object Traveller (415 : Unsupported Media Type)
//		Response response = client.target(REST_URI).path("/getTestPostXML").request(MediaType.APPLICATION_JSON).post(Entity.entity(tra, MediaType.APPLICATION_JSON));
//		System.out.println("Response for getAllTraveller : " + response.getStatus());
		
		//POST(Client JSON , WS Consume XML) Object Traveller (Unsupported Media Type)
		//request : map ws  @Produces
		//post : map ws @Consumes
//		Response response = client.target(REST_URI).path("/getTestPostXML2").request(MediaType.APPLICATION_XML).post(Entity.entity(tra, MediaType.APPLICATION_JSON));
//		System.out.println("Response for getAllTraveller : " + response.getStatus());
		
		//PUT
//		Response response = client.target(REST_URI).path("/getTestPUT").request(MediaType.APPLICATION_JSON).put(Entity.entity(tra, MediaType.APPLICATION_JSON));
//		System.out.println("Response for getAllTraveller : " + response.getStatus());
		
		//PUT ส่ง object xml
		//request : map ws  @Produces
		//put :  map ws @Consumes
//		Response response = client.target(REST_URI).path("/getTestPUT2").request(MediaType.APPLICATION_JSON).put(Entity.entity(tra, MediaType.APPLICATION_XML));
//		System.out.println("Response for getAllTraveller : " + response.getStatus());
		
		//DELETE ปกติ
//		Response response = client.target(REST_URI).path("/getTestDelete").request(MediaType.APPLICATION_JSON).delete();
//		System.out.println("Response for getAllTraveller : " + response.getStatus());
		
		//DELETE
		//request : map ws  @Produces
//		Response response = client.target(REST_URI).path("/getTestDelete2").request(MediaType.APPLICATION_JSON).delete();
//		System.out.println("Response for getAllTraveller : " + response.getStatus());
				
//		Response response = client.target(REST_URI).path("/getTestDelete2").request(MediaType.APPLICATION_XML).delete();
//		System.out.println("Response for getAllTraveller : " + response.getStatus());
		
		
		//###############################
		//###############################
		//############################### PAST บ่าย ง่วงมาก ๆ TT"
		//###############################
		//###############################
		
//		ObjectMapper mapper = new ObjectMapper();
//		
//		Traveller tr = client.target(REST_URI).path("/getParamsId").path(String.valueOf("1234567890")).request(MediaType.APPLICATION_JSON).get(Traveller.class);
//		System.out.println("Response for getAllTraveller : " + tr.getFirstName());
//		System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(tr));
//		System.out.println(mapper.writeValueAsString(tr));
				
		
		
	}
	
}
