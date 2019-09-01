package com.example.rest;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.glassfish.grizzly.http.server.HttpServer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class MyResourceTest {

    private HttpServer server;
    private WebTarget target;

    @Before
    public void setUp() throws Exception {
        // start the server
        server = Main.startServer();
        // create the client
        Client c = ClientBuilder.newClient();

        // uncomment the following line if you want to enable
        // support for JSON in the client (you also have to uncomment
        // dependency on jersey-media-json module in pom.xml and Main.startServer())
        // --
        // c.configuration().enable(new org.glassfish.jersey.media.json.JsonJaxbFeature());

        target = c.target(Main.BASE_URI);
    }

    @After
    public void tearDown() throws Exception {
        server.stop();
    }


    @Test
    public void testGetIt() {
        String responseMsg = target.path("myresource").request().get(String.class);
        assertEquals("Got it!", responseMsg);
    }

    @Test
    public void testGetAllCustomers() {
        String responseMsg = target.path("customers/all").request().get(String.class);
        //System.out.println(responseMsg);
        assertNotNull(responseMsg);
        assertTrue(responseMsg.contains("ID: 100 First: George Last: Washington"));
    }

    @Test
    public void testGetACustomers() {
        String responseMsg = target.path("customers/104").request().get(String.class);
        //System.out.println(responseMsg);
        assertNotNull(responseMsg);
        assertTrue(responseMsg.contains("ID: 100 First: George Last: Washington"));
    }
    
}
