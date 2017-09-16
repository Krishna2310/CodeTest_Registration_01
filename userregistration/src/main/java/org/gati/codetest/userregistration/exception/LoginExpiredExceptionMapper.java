package org.gati.codetest.userregistration.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;

import org.gati.codetest.userregistration.model.ErrorMessage;

public class LoginExpiredExceptionMapper implements ExceptionMapper<LoginExpiredException>{

	@Override
	public Response toResponse(LoginExpiredException ex) {
		ErrorMessage errormessage = new ErrorMessage(ex.getMessage(),404,"Login Expired");
		return Response.status(Status.REQUEST_TIMEOUT).entity(errormessage).build();
	}


}
