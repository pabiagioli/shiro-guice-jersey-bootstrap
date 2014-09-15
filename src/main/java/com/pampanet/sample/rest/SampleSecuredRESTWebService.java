package com.pampanet.sample.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;

@Path("/stuff")
public class SampleSecuredRESTWebService {

	@GET
	@Path("/allowed")
	@RequiresPermissions("lightsaber:allowed")
	@RequiresAuthentication
	public Response sayHelloToUser(){
		return Response.ok("Hello "+SecurityUtils.getSubject().getPrincipal()+"!").build();
	}
	
	@GET
	@Path("/forbidden")
	@RequiresPermissions("forbiddenForAllExceptRoot")
	public Response forbiddenToAll(){
		return Response.ok("Got Root!").build();
	}
}
