package com.cct.restful.wsservice.query;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.cct.restful.wsservice.domain.Traveller;
import com.cct.restful.wsservice.domain.TravellerDAO;

@Path("/travellerServiceWS") //การอ้างอิง WS นั้นๆ 1 Class = 1 WS จะถูกระบุไว้ใน Client ตอนเรียกใช้  Class นี้ต้องอยู่ใน package ใน web.xml
@Consumes(MediaType.APPLICATION_JSON) //มักใช้ กับ POST , PUT ( submit form object เลยต้องกำหนดว่า ws จะรับเป็นอะไร)
@Produces(MediaType.APPLICATION_JSON) //มักใช้กับ GET , DELETE ที่ส่ง Parameter เข้าไป (เราต้องการข้อมูลที่เป็นรูปแบบใด)
public class TravellerServiceWS {
	
	@GET
	@Path("/getTraveller") // กำหนดในระดับ method เพื่อระบุว่าจะมาดึงที่นี่ ถ้าไม่กำหนด @Path มันจะเข้า @GET แรกที่มันเจอ
	public Response getTraveller(){
		return Response.status(Response.Status.OK.getStatusCode()).build();
	}
	
	@GET
	@Path("/getById")
	public Response getById(){
		return Response.status(Response.Status.OK.getStatusCode()).build();
	}
	
	@GET
	@Path("/getXML")
	@Produces(MediaType.APPLICATION_XML)
	public Response testXML(){
		return Response.status(Response.Status.OK.getStatusCode()).build();
	}
	
	@POST
	@Path("/getTestPost")
	public Response testPost(){
		return Response.status(Response.Status.CREATED.getStatusCode()).build();
	}
	
	@POST
	@Path("/getTestPostXML")
	@Consumes(MediaType.APPLICATION_XML)
	public Response testPostXML(){
		return Response.status(Response.Status.CREATED.getStatusCode()).build();
	}
	
	@POST
	@Path("/getTestPostXML2")
	@Produces(MediaType.APPLICATION_XML)
	public Response testPostXML2(){
		return Response.status(Response.Status.CREATED.getStatusCode()).build();
	}
	
	@PUT
	@Path("/getTestPUT")
	public Response testPut(){
		return Response.status(Response.Status.CREATED.getStatusCode()).build();
	}
	
	@PUT
	@Path("/getTestPUT2")
	@Consumes(MediaType.APPLICATION_XML)
	public Response testPut2(){
		return Response.status(Response.Status.CREATED.getStatusCode()).build();
	}
	
	@DELETE
	@Path("/getTestDelete")
	public Response testDelete(){
		return Response.status(Response.Status.OK.getStatusCode()).build();
	}
	
	@DELETE
	@Path("/getTestDelete2")
	@Produces(MediaType.APPLICATION_XML)
	public Response testDelete2(){
		return Response.status(Response.Status.OK.getStatusCode()).build();
	}
	
	//#####
	//##### PAST บ่าย ง่วงมาก ๆ TT"
	//#####
	
	@GET
	@Path("/getParamsId/{xxx}")
	public Traveller getParamsId(@PathParam("xxx")int id){
		System.out.println("getParamsId : " + id);
		return new TravellerDAO().getTraveller(id);
	}
	
	@GET
	@Path("/getParamsId/{xxx}/{yyy}")
	public Traveller getParamsId(@PathParam("xxx")int id,@PathParam("yyy")int name){
		System.out.println("getParamsId : " + id);
		System.out.println("getParamsName : " + name);
		return new TravellerDAO().getTraveller(id);
	}
	
	@GET
	@Path("/getParamsIdString/{xxx}")
	public String getParamsIdString(@PathParam("xxx")String id){
		System.out.println("getParamsId : " + id);
		System.out.println("length : " + id.length());
		return "";
	}
	
	
	
}
