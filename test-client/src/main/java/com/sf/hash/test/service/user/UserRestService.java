package com.sf.hash.test.service.user;

import java.util.List;

import javax.validation.constraints.Min;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.sf.hash.test.domain.TaskDemo;
import com.sf.hash.test.domain.UserDemo;


@Path("user")
@Consumes({MediaType.APPLICATION_JSON, MediaType.TEXT_HTML, MediaType.TEXT_PLAIN, MediaType.TEXT_XML})
@Produces({MediaType.APPLICATION_JSON + "; " + MediaType.CHARSET_PARAMETER + "=UTF-8", MediaType.TEXT_XML + "; " + MediaType.CHARSET_PARAMETER + "=UTF-8"})

public interface UserRestService {
	@GET
    @Path("{id : \\d+}")
	UserDemo getUser(@PathParam("id") @Min(1) Integer id);
	
	@POST
    @Path("add")
    String addUser(UserDemo userDemo);
	
	@DELETE
    @Path("delete/{id : \\d+}")
	String deleteUser(@PathParam("id") @Min(1) Integer id);
	
	@POST
	@Path("update")
	String updateUser(UserDemo userDemo);
	
	@GET
	@Path("{id : \\d+}/tasks")
	List<TaskDemo> userTasks(@PathParam("id") @Min(1) Integer id);
}
