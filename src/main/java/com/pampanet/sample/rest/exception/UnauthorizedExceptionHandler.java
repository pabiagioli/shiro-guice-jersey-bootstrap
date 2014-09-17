package com.pampanet.sample.rest.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.apache.shiro.authz.UnauthorizedException;

import com.sun.jersey.api.client.ClientResponse.Status;

@Provider
public class UnauthorizedExceptionHandler implements ExceptionMapper<UnauthorizedException>{
	
	@Override
	public Response toResponse(UnauthorizedException exception) {
		
		return Response.status(Status.UNAUTHORIZED)
				.entity(new ExceptionResponse(
						exception.getClass().getSimpleName(),
						exception.getMessage()))
						.build();
	}
	
	
}
