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
 