My Basic Axis2 Hello World App Service - Brilliant!
--------------------------------------------------------------
- Prove that I got a college degree, and ,,,,,,,,
- Somehow creating a hello application.
- Not only can I it say hello, but I can create a Web Service to do it.


Build It
-----------------------------
mvn clean install package

- Created in the root directory is: HelloWorldService.aar


Deploy It
--------------------

- Start your axis2 version
- Plop HelloWorldService.aar into the directory: ../repository/services/
- You should see this deployed service:

HelloWorldService
Available operations
    message


Prove it!
----------------------------------------
- See! I told you I went to college!
- Now for the other parts of my live, as a Java Developer, Web Developer and Architect?\


Create Axis2 Maven Bare Bone Project Maven POM Info
--------------------------------------------------------------------
o Use Axis2 Maven Plugin to build WSDL (Web Services Definition Language) From Java code

			<plugin>
				<groupId>org.apache.axis2</groupId>
				<artifactId>axis2-java2wsdl-maven-plugin</artifactId>
				<configuration>
					<className>com.aikiinc.axis2.hello.HelloWorld</className>
					<outputFileName>${project.build.directory}/HelloWorld.wsdl</outputFileName>
				</configuration>
				<executions>
					<execution>
						<phase>process-classes</phase>
						<goals>
							<goal>java2wsdl</goal>
						</goals>
					</execution>
				</executions>
			</plugin>

o Use Axis2 Maven Plugin to build Axis Archive (*.aar) From Axis Deployment Descripto service.xml

			<plugin>
				<groupId>org.apache.axis2</groupId>
				<artifactId>axis2-aar-maven-plugin</artifactId>
				<configuration>
					<servicesXmlFile>${basedir}/src/resources/services.xml</servicesXmlFile>
					<wsdlFile>${project.build.directory}/HelloWorld.wsdl</wsdlFile>
				</configuration>
				<executions>
					<execution>
						<phase>package</phase>
						<goals>
							<goal>aar</goal>
						</goals>
					</execution>
				</executions>
			</plugin>


Running the Client
-----------------------------------------
- Use WSDL
http://localhost:8080/axis2/services/StockQuoteService?wsdl

- Say Hello
http://localhost:8080/axis2/services/HelloWorldService/message?name=This is it!

The web service responds with:
<ns:messageResponse><ns:return>Hello : This is it!</ns:return></ns:messageResponse>

