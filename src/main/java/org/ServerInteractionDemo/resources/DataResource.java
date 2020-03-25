package org.ServerInteractionDemo.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/content")
public class DataResource {

    @GET
    public Response getData() {
        return Response.ok("Static Content").build();
    }


}
