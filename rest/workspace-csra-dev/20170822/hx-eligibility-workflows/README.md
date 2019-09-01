Processing Member Eligibility JBPM Configuration (Real Basic Sample Approach)
-----------------------------------------------------------------------------------
This is the first execution flow using JBPM workflows. The flow is triggered using
JUnit test WF_MI_Main_EligibilityTest.java. It also is supported by a helper class
WFTestBase.java. Run the test to see the print out of the processing flow.    
 
Goal
------------
1. To demonstrate the configuration and JBPM 7 processing work flow.
2. Show that the POC is able to execute business requirement using JBPM 7.
3.  This is a bare minimum setup to demonstrate how to configure JPBM to:
o Handle business processing flow using JBPM business model files.
o Handle business processing flow using JBPM and Drools Rule. 


Scope
------------
Use the bare minimum Eligibility processing of members to acquire insurance.  


Domains Used
------------
Member - Captures name, income and aging category. Is member new born, infant, youth, senior, etc.

EligibilityResult - Captures the end result of processing eligibility by capturing the eligibility status and reason.


Supporting Object
------------
EligibilityMain - Handles the process flow artifacts in the JBPM process MI_Main.bpmn2. 
Each JBPM process file (jbpm2) should have a POJO object to capture the various conditions.
For now I only coded some of the MI_Main.bpmn2 business processing model.

 
Sample Business Rule Considered (Requirements)
--------------------------------------------------
The main Business Model file used is MI_Main.bpmn2. Its trajectory for supporting sub processes and drools rules. 

Requirement 1: Member information is stale - set status ineligible.
How its coded: 
	See "Stale" gateway.
	This done via processing work flow gateway decision. 
Recommendation: 
	Put a rule process in front of this decision and not use the work flow.

Requirement 2: HouseHold Income Over Limit (50000) - set status ineligible.
How its coded:
	See  "MI_MainSub_IncomeTypeDetermination" SubProcess
	This done via SubProcess processing work flow. 
	Where the sub process calls a Drools Rule to process condition.

Requirement 3: Member is new born - set income type: CHIP
How its coded:
	See  "MI_MainSub_FPLLevelDetermination" SubProcess
	This done via SubProcess processing work flow. 
	Where the sub process calls a Drools Rule to process condition.

Requirement 4: Member is new born And incomeType = "CHIP" - set houseHold income limit to 10000.
        Set status ineligible.
How its coded:
	See  "MI_MainSub_CheckIncomeReasonableCompatability" SubProcess
	This done via SubProcess processing work flow. 
	Where the sub process calls a Drools Rule to process condition.

Building Project
-----------------------------------------------------------------------------------
Requirements:
o Need JDK 1.8 not JRE 1.8
  I installed JDK on my machine at: C:\bin\jdk1.8.0_131

o Need Maven
  I installed maven based on the normal CSRA project configurations:
  C:\dev\softwares\apache-maven-3.0.4


Scripts To Ease Building
------------------------------
o setjdk18.cmd 
Here is a scripts I used to set my environment: 
echo off
cls
set JAVA_HOME=C:\bin\jdk1.8.0_131
echo .
echo JAVA_HOME=%JAVA_HOME% 
echo .

set CYGBIN=C:\cygwin64/bin
set WINPATH=C:\windows\system32;C:\windows;C:\windows\System32\Wbem;C:\windows\System32\WindowsPowerShell\v1.0 
set DEVPATH=.;C:\batch;
set PATH=%WINPATH%;%CYGBIN%;%JAVA_HOME%\bin;%DEVPATH%;
rem set PATH=%WINPATH%;%JAVA_HOME%\bin;%DEVPATH%;
echo PATH=%PATH% 
echo .

call setmvn

o setmvn.cmd
SET MAVEN_HOME=C:\dev\softwares\apache-maven-3.0.4
echo MAVEN_HOME=%MAVEN_HOME% 
              
SET PATH=%PATH%;%MAVEN_HOME%\BIN

Recommendation:
	Since I go back and for between the new CSRA JBPM and normal CSRA,	I needed these scripts.	

Building Project
-----------------------------
Once this project is cloned from repository, go to that directory:
Ex: cd C:\A-DEV\workspace-csrra-sandbox\20170802\hx-eligibility-workflows

Issue:
mvn clean install

- Code will compile and run some alpha version test of work flow processing using JBPM 7.

DONE!
 