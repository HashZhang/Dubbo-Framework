package com.sf.hash.test.service.demo;

import java.util.List;

import javax.validation.constraints.Min;
import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import com.sf.framework.domain.Request;
import com.sf.framework.domain.Result;
import com.sf.hash.test.domain.Demo;

@Path("demo")
@Consumes({MediaType.APPLICATION_JSON, MediaType.TEXT_HTML, MediaType.TEXT_PLAIN, MediaType.TEXT_XML})
@Produces({MediaType.APPLICATION_JSON + "; " + MediaType.CHARSET_PARAMETER + "=UTF-8", MediaType.TEXT_XML + "; " + MediaType.CHARSET_PARAMETER + "=UTF-8"})
public interface DemoRestService {

	@GET
    @Path("{id : \\d+}")
    Demo getDemo(@PathParam("id") @Min(1) Integer id);

    @POST
    @Path("register")
    Integer registerDemo(Demo demo);
    
    @POST
    @Path("query")
    Result<List<Demo>> query(Request<String> request, @QueryParam("id") Integer id);
    
    
    @POST
    @Path("queryList")
    //Result<List<Demo>> queryList(Request<String> request, @Context UriInfo uriInfo, @Context HttpHeaders httpHeaders);
    Result<List<Demo>> queryList(Request<String> request);
}
