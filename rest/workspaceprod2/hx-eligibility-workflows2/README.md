Processing Member Eligibility JBPM Configuration (Real Basic Sample Approach)
-----------------------------------------------------------------------------------
This is the another execution flow using JBPM workflows. The flow is triggered using
JUnit test WF_MI_Main_EligibilityTest.java. It also is supported by a helper class
WFTestBase.java. Run the test to see the print out of the processing flow.    

o Business Logics are pure processing flows
  The business logic for the processing members are not only pur workflows.
  No Drools rule are used. This will allow business uses to only create rules 
  using diagrams. Developers and others benefit also.
  
  THEY CAN SEE WHAT THEY ARE DOING CLEARER!
  
  The process flows can be found in the package in the resources directory: 
  com.csra.eligibility.process.member.MBR_Precheck_Household_Income.bpmn2	
  com.csra.eligibility.process.member.MBR_FPL_Level_Determination.bpmn2
  com.csra.eligibility.process.member.MBR_Income_Type_Determination.bpmn2
  com.csra.eligibility.process.member.MBR_Income_Type_Compatibility.bpmn2
  
o The test base is a seperate maven project - more modular.
  See hx-eligibility-testbase and the other test that use it:
  hx-eligibility-memberrules-test, hx-eligibility-workflows-test.
  
o The DTOs are a seperate project, both pojos and its test. 
  See hx-eligibility-dto and hx-eligibility-dto-test.
  

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

 
Sample Test Scenarios To Test Business Rules In KIE Workbench
-----------------------------------------------------------------------------
See the kieworkbenchtestscenarios.md for test scenerios in KIE workbench.
It provides the values entered in the form and which rules get's fired/executed.

