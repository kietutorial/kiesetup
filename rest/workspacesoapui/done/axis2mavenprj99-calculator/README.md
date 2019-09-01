Create Axis2 Maven Bare Bone Project
------------------------------------------
o Use Axis2 Maven Plugin to build WSDL (Web Services Definition Language) From Java code

			<plugin>
				<groupId>org.apache.axis2</groupId>
				<artifactId>axis2-java2wsdl-maven-plugin</artifactId>
				<configuration>
					<className>com.aikiinc.axis2.serivces.CalculatorService</className>
					<outputFileName>${project.build.directory}/CalculatorService.wsdl</outputFileName>
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
					<wsdlFile>${project.build.directory}/CalculatorService.wsdl</wsdlFile>
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

			
My Basic Axis2 Service - Brilliant!
-------------------------------------------
- Prove that I got a college degree!
- By, somehow adding two numbers. Let me prove it to you!
- Not only can I add two numbers, but I can create a Web Service to do it.


Build It
-----------------------------
mvn clean install package

- Created in the root directory is: basiccalc.aar


Deploy It
--------------------

- Start your axis2 version
- Plop basiccalc.aar into the directory: ../repository/services/
- You should see this deployed service:

CalculatorService
Available operations
    setNum2
    setNum1
    getSum
    

Prove it!
----------------------------------------
- See! I told you I went to college!
- Now for the other parts of my live, as a Java Developer, Web Developer and Architect?
