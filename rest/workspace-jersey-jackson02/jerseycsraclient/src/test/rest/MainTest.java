package com.example.rest;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.glassfish.grizzly.http.server.HttpServer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mkyong.Track;
import com.mkyong.rest.Main;

import static org.junit.Assert.*;

public class MainTest {
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
    public void getWADL() {
        String responseMsg = target.path("application.wadl").request().get(String.class);
        
        //System.out.println(responseMsg);

        assertNotNull(responseMsg);
        assertTrue(responseMsg.contains("http://wadl.dev.java.net/"));
        assertTrue(responseMsg.contains("http://localhost:8080/mykong"));
    }

    @Test
    public void getIt() {
        String responseMsg = target.path("myresource").request().get(String.class);
        assertNotNull(responseMsg);
        assertEquals("Got it!", responseMsg);
    }

    @Test
    public void getTrack() {
        String responseMsg = target.path("json/metallica/get").request().get(String.class);
        System.out.println(responseMsg);
        
        assertNotNull(responseMsg);
        assertTrue(responseMsg.contains("{\"singer\":\"Metallica\",\"title\":\"Enter Sandman\"}"));
    }

    @Test
    public void postTargetWithPojo() {
    	Track track = new Track();
		track.setTitle("Enter Sandman");
		track.setSinger("Metallica");    	
    	Entity<Track> userEntity = Entity.entity(track, MediaType.APPLICATION_JSON_TYPE);

    	String responseMsg = target.path("json/metallica/post")
                .request()
                .post(Entity.json(track), String.class);
    	
        System.out.println(responseMsg);
        assertNotNull(responseMsg);
        assertTrue(responseMsg.equals("Track saved : Track [title=Enter Sandman, singer=Metallica]"));
    }


    @Test
    public void postTargetString() {
    	String responseMsg = target.path("json/metallica/post")
                .request()
                .post(Entity.json("{\"singer\":\"Metallica\",\"title\":\"Enter Sandman\"}"), String.class);

        System.out.println(responseMsg);
        assertNotNull(responseMsg);
        assertTrue(responseMsg.equals("Track saved : Track [title=Enter Sandman, singer=Metallica]"));
    }

}
