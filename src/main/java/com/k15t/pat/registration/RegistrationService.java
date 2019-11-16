package com.k15t.pat.registration;

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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.k15t.pat.exceptions.UserAlreadyRegisteredException;
import com.k15t.pat.exceptions.UserNotFoundException;

/**
 * This is the rest end point that has GET and POST methods
 * GET is to query for a given user
 * POST is to create a new Registration
 * 
 * @author pythonprojects
 *
 */
@Service
@Path("registration")
public class RegistrationService {

    @Autowired 
	private RegistrationRepository registrationService; 

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{user}")
    public Response returnUser(@PathParam("user") String user) throws UserNotFoundException{
    	    return Response.status(Response.Status.OK.getStatusCode())
		    		.entity(registrationService.getUser(user))	
					.build();
    }
    
	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	@RequestMapping("/")
	public Response save(Registration registration)	throws UserAlreadyRegisteredException { 
    		Registration savedObject = registrationService.save(registration);
			return Response.status(Response.Status.CREATED.getStatusCode())
					.entity(savedObject)
					.type(MediaType.APPLICATION_JSON)
					.build();
	}
	
	
	@PUT
	@Consumes({ MediaType.APPLICATION_JSON })
	@RequestMapping("/")
	@Path("{user}")
	public Response update(Registration registration, @PathParam("user") String user)	throws UserNotFoundException { 
    		Registration updateObject = registrationService.update(registration);
			return Response.status(Response.Status.OK.getStatusCode())
					.entity(updateObject)
					.type(MediaType.APPLICATION_JSON)
					.build();
	}
	
	@DELETE
	@Consumes({ MediaType.APPLICATION_JSON })
	@RequestMapping("/")
	@Path("{user}")
	public Response delete( @PathParam("user") String user)	throws UserNotFoundException { 
    		Registration deleteObject = registrationService.getUser(user);
    		registrationService.delete(deleteObject.getUser());
			return Response.status(Response.Status.NO_CONTENT)
					.type(MediaType.APPLICATION_JSON)
					.build();
	
	}
	
}
