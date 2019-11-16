package com.k15t.pat.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
/**
 * Generic mapper for UserNotFoundException,
 *  returns 404 HTTP status code
 * @author pythonprojects
 *
 */
@Provider
public class UserNotFoundMapper implements
        ExceptionMapper<UserNotFoundException> { 
    @Override
    public Response toResponse(UserNotFoundException ex) {
        return Response.status(404)
        		.entity(ex.getMessage())
        		//.type("text/plain")
                .build();
    }
}