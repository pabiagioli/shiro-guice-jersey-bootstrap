package com.pampanet.sample.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.sun.jersey.spi.resource.Singleton;

@Singleton
@Path("hello")
public class SampleRESTWebService {

	@Inject
	@Named("hello.world.string")
	private String helloWorldString;
	
	@GET
	@Produces("application/json")
	public Response helloWorld(){
		return Response.ok(helloWorldString+"\n").build();
	}
}
