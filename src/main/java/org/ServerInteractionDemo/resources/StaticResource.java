package org.ServerInteractionDemo.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/static")
public class StaticResource {

    @GET
    public Response getData() {
        return Response.ok("Static Content").build();
    }


}
