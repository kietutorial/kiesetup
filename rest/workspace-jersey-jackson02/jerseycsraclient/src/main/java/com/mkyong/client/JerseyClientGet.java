package com.mkyong.client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;

public class JerseyClientGet {
	public static final String BASE_URI = "http://localhost:9080/kie-server/services/rest/server/containers/hx-eligibility-workflows_1.0.2";
	
		
	public static void main(String[] args) {
		try {
			HTTPBasicAuthFilter authentif = (new HTTPBasicAuthFilter("pchauvet", "pchauvet"));
			
			Client client = getClient(authentif);
			
			WebResource webResource = client.resource(BASE_URI + "");
			ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);

			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
			}

			String output = response.getEntity(String.class);
			System.out.println("Output from Server .... \n");
			System.out.println(output);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}


	private static Client getClient(HTTPBasicAuthFilter authentif) {
		Client client = Client.create();
		client.addFilter(authentif);
		return client;
	}

}