package org.gati.codetest.userregistration.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import org.gati.codetest.userregistration.model.UserDetail;
import org.gati.codetest.userregistration.service.ResgistrationService;


@Path("/register")
public class ClientRegistration {
	
	ResgistrationService registrationservice = new ResgistrationService(); 
    
    @GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<UserDetail> getAllUserDetails() {
		return registrationservice.getAllUserDetails();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public UserDetail addUser(UserDetail userdetail,@Context UriInfo uriinfo) {
		UserDetail userlogin = registrationservice.addUser(userdetail);
		String uri=uriinfo.getBaseUriBuilder()
				.path(ClientRegistration.class)
				.path(Long.toString(userdetail.getUserid()))
				.build()
				.toString();
		userlogin.addLink(uri,"login");
		return userlogin;
	}
	
	@GET
	@Path("/{test}")
	@Produces(MediaType.APPLICATION_JSON)
	public UserDetail getTest(@PathParam("test") long userid,@Context UriInfo uriinfo) {		
		UserDetail userdetail= registrationservice.getMessage(userid);
		String uri=uriinfo.getBaseUriBuilder()
				.path(ClientRegistration.class)
				.path(Long.toString(userdetail.getUserid()))
				.build()
				.toString();
		//userdetail.addLink(uri,"login");
		return userdetail;
	}
	
}
