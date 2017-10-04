package com.cct.restful.wsservice.query;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import com.cct.restful.wsservice.domain.Traveller;
import com.cct.restful.wsservice.domain.TravellerDAO;

@Path("/travellerServiceWSQuery")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TravellerServiceWSQuery {
	
	@GET
	@Path("/getTravellerByIdQuery")
	public Traveller getTravellerByIdQuery(@QueryParam("id") int id){
		System.out.println("getTravellerByIdQuery : " + id);
		return new TravellerDAO().getTraveller(id);	
	}
	
	@GET
	@Path("/getTravellerByIdQuery2")
	public Traveller getTravellerByIdQuery2(@QueryParam("id") int id , @QueryParam("name") String name){
		System.out.println("getTravellerByIdQuery2 Id : " + id);
		System.out.println("getTravellerByIdQuery2 Name : " + name);
		return new TravellerDAO().getTraveller(id);	
	}
	
	@GET
	@Path("/getTravellerByIdQuery3")
	public Traveller getTravellerByIdQuery3(@Context UriInfo uriInfo){
		int id = Integer.parseInt(uriInfo.getQueryParameters().getFirst("id"));
		List<String> name = uriInfo.getQueryParameters().get("name");
		System.out.println("getTravellerByIdQuery3 : " + id);
		System.out.println("getTravellerByIdQuery3 : " + name);
		return new TravellerDAO().getTraveller(id);	
	}
	
	@GET
	@Path("/getTravellerByIdQuery4")
	public Traveller getTravellerByIdQuery4(@QueryParam("id") int id , @DefaultValue("Hi") @QueryParam("name") String name ){
		System.out.println("getTravellerByIdQuery4 Id : " + id);
		System.out.println("getTravellerByIdQuery4 Name : " + name);
		return new TravellerDAO().getTraveller(id);	
	}
	
}
