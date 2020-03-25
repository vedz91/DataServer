package org.ServerInteractionDemo.resources;

import org.junit.jupiter.api.Test;

import javax.ws.rs.core.Response;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class StaticResourceTest {

    @Test
    public void testStaticContent() {
        StaticResource staticResource = new StaticResource();

        Response res = staticResource.getData();
        assertEquals("Static Content", res.getEntity());
    }
}
