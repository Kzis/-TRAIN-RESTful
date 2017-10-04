package com.cct.restful.wsservice.path;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import com.cct.restful.wsservice.domain.Traveller;
import com.cct.restful.wsservice.domain.TravellerDAO;

@Path("/travellerServiceWSPath")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TravellerServiceWSPath {
	
	@GET
	@Path("/getTravellerByIdPath/{id}")
	public Traveller getTravellerByIdPath(@PathParam("id") int id){
		System.out.println("getTravellerByIdPath : " + id);
		return new TravellerDAO().getTraveller(id);	
	}
	
	@GET
	@Path("/getTravellerByIdPath2/{id}/{name}")
	public Traveller getTravellerByIdPath2(@PathParam("id") int id , @PathParam("name") String name){
		System.out.println("getTravellerByIdPath Id : " + id);
		System.out.println("getTravellerByIdPath Name : " + name);
		return new TravellerDAO().getTraveller(id);	
	}
		
	@GET
	@Path("/getTravellerByIdPath3/{id}")
	public Traveller getTravellerByIdPath3(@Context UriInfo uriInfo){
		int id = Integer.parseInt(uriInfo.getPathParameters().getFirst("id"));
		System.out.println("getTravellerByIdPath3 : " + id);
		return new TravellerDAO().getTraveller(id);	
	}
	
	@GET
	@Path("/getTravellerByIdPath4/{id}-{name}")
	public Traveller getTravellerByIdPath4(@PathParam("id") int id , @PathParam("name") String name){
		System.out.println("getTravellerByIdPath Id : " + id);
		System.out.println("getTravellerByIdPath Name : " + name);
		return new TravellerDAO().getTraveller(id);	
	}
	

}
