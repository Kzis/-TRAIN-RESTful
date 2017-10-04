package com.cct.restful.wsservice.client;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.media.multipart.FormDataMultiPart;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.media.multipart.file.FileDataBodyPart;

import com.cct.restful.wsservice.domain.Address;
import com.cct.restful.wsservice.domain.Traveller;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ClientUploadFile {
	public static String IMG1 = "C:/Users/Admin/Desktop/pic/background/unnamed.jpg";
	public static String IMG2 = "C:/Users/Admin/Desktop/pic/background/rfwDB3L.png";
	public static String END_POINT = "http://localhost:8081/RESTfulDemo/rest/upload/";
	
	public static void main(String[] args)
	{
		try {
			upload();
			upload2();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Client upload
	 * @throws Exception
	 */
	private static void upload() throws Exception{
		FormDataMultiPart formDataMultiPart = new FormDataMultiPart();
		FormDataMultiPart multipart = null;
		
		try {
			Client client = ClientBuilder.newBuilder().register(MultiPartFeature.class).build();
			
			//1.Simulate data information
			List<Address> listAddress = new ArrayList<Address>();
			Address addr = new Address("56/43", "08-9555-2020");
			listAddress.add(addr);
			addr = new Address("102/3", "08-9555-2020");
			listAddress.add(addr);
			
			Traveller traveller = new Traveller(1, "Manit", listAddress);
			
			ObjectMapper mapper = new ObjectMapper();
			String jsonString = mapper.writeValueAsString(traveller);
			
			//2.Prepare data and image
			FileDataBodyPart filePart = new FileDataBodyPart("file", new File(IMG1));
			multipart = (FormDataMultiPart) formDataMultiPart.field("data", jsonString).bodyPart(filePart);
			
			//3.Invoke ws
			WebTarget target = client.target(END_POINT).path("image");
			Response response = target.request().post(Entity.entity(multipart, multipart.getMediaType()));
			
			//4.Use response object to verify upload success
			System.out.println("Upload Complete " + response.getStatus());
			
		} catch (Exception e) {
			throw e;
		} finally {
			formDataMultiPart.close();
			multipart.close();
		}
	}
	
	private static void upload2() throws Exception{
		FormDataMultiPart formDataMultiPart = new FormDataMultiPart();
		FormDataMultiPart multipart = null;
		
		try {
			Client client = ClientBuilder.newBuilder().register(MultiPartFeature.class).build();
			
			//1.Simulate data information
			List<Address> listAddress = new ArrayList<Address>();
			Address addr = new Address("56/43", "08-9555-2020");
			listAddress.add(addr);
			addr = new Address("102/3", "08-9555-2020");
			listAddress.add(addr);
			
			Traveller traveller = new Traveller(1, "Manit", listAddress);
			
			ObjectMapper mapper = new ObjectMapper();
			String jsonString = mapper.writeValueAsString(traveller);
			
			//2.Prepare data and image
			FileDataBodyPart filePart = new FileDataBodyPart("file", new File(IMG1));
			FileDataBodyPart filePart2 = new FileDataBodyPart("file", new File(IMG1));
			multipart = (FormDataMultiPart) formDataMultiPart.field("data", jsonString).bodyPart(filePart).bodyPart(filePart2);
			
			//3.Invoke ws
			WebTarget target = client.target(END_POINT).path("image2");
			Response response = target.request().post(Entity.entity(multipart, multipart.getMediaType()));
			
			//4.Use response object to verify upload success
			System.out.println("Upload Complete " + response.getStatus());
			
		} catch (Exception e) {
			throw e;
		} finally {
			formDataMultiPart.close();
			multipart.close();
		}
	}
}
