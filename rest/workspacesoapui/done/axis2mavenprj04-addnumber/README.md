My Basic Axis2 Add Two Number Service - Brilliant!
--------------------------------------------------------------
- We can do it! 
- That is, prove we have the ability to add two numbers.


Preface (THE BORG MINDSET)
-----------------------------------------
- I will take it upon myself to speak for you!
- Resistance is futile!
- We are of a collective mind.
- Our technological distinction is to speak on: Axis 2 Web Services (WS)
- Resistance is futile!


TASK (Business Rule)
-----------------------
- Since we are BORG's our primary directive:

Task 1: Prove we, meaning I, got a college degree!

Task 2: Add two numbers. 
Task 2 Coincidence: Somehow prove that this operation is because of college.

Task 3: Use Axis2 WS to prove it?

Task 4: Assimilate the project as a Maven Axis2 project?


Build It
-----------------------------
- Download or use GIT to clone this code.
- use:
mvn clean install package

- Created in the root directory is: AddNumber.aar
- This is our Axis2 Archive file (Web Service Archive) to be deployed


Deploy It
--------------------
- Start your axis2 version - you figure that out?
- Plop AddNumber.aar into the directory: ../repository/services/
- Oh yeah! Add this function to the collective!
- You should see this deployed service, that will now be known, by all:

AddNumber
Available operations
    add


Proved it!
----------------------------------------
- We reached our prime directive, our station in the collective, and goal!
- See! I told you I went to college!
- Now for the other parts of my live, as a Java Developer, Web Developer and Architect?

* Please resist, resist, resist! You will feel better for trying.


Details: Axis2 Maven POM Info
--------------------------------------------------------------------
o Use Axis2 Maven Plugin to build WSDL (Web Services Definition Language) From Java code

			<plugin>
				<groupId>org.apache.axis2</groupId>
				<artifactId>axis2-java2wsdl-maven-plugin</artifactId>
				<configuration>
					<className>com.aikiinc.axis2.mathoperation.Add</className>
					<outputFileName>${project.build.directory}/AddNumber.wsdl</outputFileName>
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
					<wsdlFile>${project.build.directory}/AddNumber.wsdl</wsdlFile>
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


Details: Axis Web Service Definition File: servicex.xml
---------------------------------------------------------------
- I stripped out a lot of the usual configuration and let the essentials:

<service>
	<parameter name="ServiceClass">com.aikiinc.axis2.mathoperation.AddNumber</parameter>
	<operation name="add">
		<messageReceiver class="org.apache.axis2.rpc.receivers.RPCMessageReceiver" />
	</operation>
</service>

-ServiceClass: Define the service Java class
-operation name="add": Define the WS name as :add"
-messageReceiver: WS should have a messageReceiver



Finally - The Service Implementation
--------------------------------------------------
public class AddNumber {

	public int add(int num1, int num2) {
		return num1 + num2;
	}

}

- What! That's it?
- Yup! The service is a simple POGO with a add() method
- add() method adfs two numbers


Details: Client Use Of AddNumber Service
--------------------------------------------
- See WSDL:
http://localhost:8080/axis2/services/AddNumber?wsdl

- Use WS Service:
http://localhost:8080/axis2/services/AddNumber/add?num1=3&num2=7

The web service responds with:
- <ns:addResponse>
- <ns:return>10</ns:return>
- </ns:addResponse>


Brilliant!
-----------------------------------------
- This has been a simple Axis2 Web service project
- An Axis2 project configured using Maven


What We Drones Should Really Do
-----------------------------------------
- We should really be doing this process using Behavioral Driven Development (BDD)
- We should be doing TDD (Test Driven Development)?

- At some point, we will do so, for now we had to meet our prime directive: 
- 1. I proved that I went to college? Sometimes, my assimilation is not to clear, I tend to resist!
- 2. Show a basic Axis2 maven project that can add two numbers.




