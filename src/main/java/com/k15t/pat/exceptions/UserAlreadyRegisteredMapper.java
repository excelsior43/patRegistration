package com.k15t.pat.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
/**
 * 
 * ExceptionMapper sends back a generic 406 response to the front-end.
 * @author pythonprojects
 *
 */
@Provider
public class UserAlreadyRegisteredMapper
  implements ExceptionMapper<UserAlreadyRegisteredException> {
  
	private static final long serialVersionUID = 1L;
	 
    public UserAlreadyRegisteredMapper() {
        super();
    }
   
	@Override
    public Response toResponse(UserAlreadyRegisteredException exception) { 
		return Response.status(Status.NOT_ACCEPTABLE)
				.entity(exception.getMessage())
                .build();
    }
}