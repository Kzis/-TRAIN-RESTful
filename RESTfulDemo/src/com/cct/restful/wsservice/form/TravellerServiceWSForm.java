package com.cct.restful.wsservice.form;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.cct.restful.wsservice.domain.Traveller;
import com.cct.restful.wsservice.domain.TravellerDAO;

@Path("/travellerServiceWSForm")
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_FORM_URLENCODED })
public class TravellerServiceWSForm {

	@POST
	@Path("/addTraveller")
	public Response addTraveller(@FormParam("id") int id, @FormParam("name") String name) {
		System.out.println("addTraveller: id > " + id);
		System.out.println("addTraveller: name > " + name);

		Traveller traveller = new Traveller();
		traveller.setId(id);
		traveller.setFirstName(name);
		new TravellerDAO().addTraveller(traveller);

		return Response.status(Response.Status.CREATED.getStatusCode())
				.entity("addTraveller is called, id : " + id + ", name : " + name).build();
	}

}
