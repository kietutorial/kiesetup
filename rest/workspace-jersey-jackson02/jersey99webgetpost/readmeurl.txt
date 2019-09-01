Uncomment in pom.xml for JSON support
		<dependency>
			<groupId>org.glassfish.jersey.media</groupId>
			<artifactId>jersey-media-moxy</artifactId>
		</dependency>


GET
	http://localhost:8080/mykong/application.wadl
Response	
	<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
	<application xmlns="http://wadl.dev.java.net/2009/02">
	    <doc xmlns:jersey="http://jersey.java.net/" jersey:generatedBy="Jersey: 2.25.1 2017-01-19 16:23:50"/>
	    <doc xmlns:jersey="http://jersey.java.net/" jersey:hint="This is simplified WADL with user and core resources only. To get full WADL with extended resources use the query parameter detail. Link: http://localhost:8080/mykong/application.wadl?detail=true"/>
	    <grammars/>
	    <resources base="http://localhost:8080/mykong/">
	        <resource path="/json/metallica">
	            <resource path="/get">
	                <method id="getTrackInJSON" name="GET">
	                    <response>
	                        <representation mediaType="application/json"/>
	                    </response>
	                </method>
	            </resource>
	            <resource path="/post">
	                <method id="createTrackInJSON" name="POST">
	                    <request>
	                        <representation mediaType="application/json"/>
	                    </request>
	                    <response>
	                        <representation mediaType="*/*"/>
	                    </response>
	                </method>
	            </resource>
	        </resource>
	    </resources>
	</application>


GET
	http://localhost:8080/mykong/json/metallica/get
Response
	{"singer":"Metallica","title":"Enter Sandman"}
	

POST
	http://localhost:8080/mykong/json/metallica/post
	Content-type: json
	Body
	{"singer":"Metallica","title":"Enter Sandman"}
	
Response
	Track saved : Track [title=Enter Sandman, singer=Metallica]
	
