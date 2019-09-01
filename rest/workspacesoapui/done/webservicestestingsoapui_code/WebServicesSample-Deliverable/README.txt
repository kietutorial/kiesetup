This is the deployable artifact of Hotel Reservation web service samples. All examples of "Web Services Testing with soapUI" book is based on these web services.

Sample Pre-requisites:
=======================
1. Download and install Apache Axis2 version 1.6.1 or later (http://axis.apache.org/axis2/java/core/download.cgi)
2. Download and install MySQL database management system (http://www.mysql.com/downloads/mysql)

INSTALLATION INSTRUCTIONS
=========================
1. Open mysql.properties file which can be found at the conf directory of HotelReservation.aar 
(You can extract the files in to local file system or edit inside the archive depending on the archiving tool you use)
Edit the following properties according to the settings of your MySQL server instalation.
mysql.host=localhost
mysql.port=3306
mysql.username=root
mysql.password=root
2. Save the archive (Re-archive if you extract the files in HotelReservation.aar to do the above changes)
3. Open a MySQL command window and run the dbscripts\HotelReservationDBSchema.sql
e.g:-
mysql> source HotelReservationDBSchema.sql;
Query OK, 1 row affected (0.00 sec)

Database changed
Query OK, 0 rows affected (0.09 sec)

Query OK, 0 rows affected (0.09 sec)

Query OK, 0 rows affected (0.14 sec)

mysql>
4. Now, deploy HotelReservation.aar in Apache Axis2 by copying HotelReservation.aar to AXIS2_HOME\repository\services directory (AXIS2_HOME is the root directory of the Axis2 binary distribution)

5. Make sure to copy MySql jdbc driver (i.e:- mysql-connector-java-5.x.x-bin.jar) which you may have downloaded from http://www.mysql.com/downloads/connector/j/ to AXIS2_HOME/lib directory
   to facilitate jdbc connectivity between Web service implementation classes and MySql database
6. Start Axis2 server by running AXIS2_HOME/bin/axis2server.sh {bat}

7. Access http://localhost:8080/axis2/services
You will find the following 3 Web services there.

GuestManagementService
RoomManagementService
ReservationService

That's all. Happy Testing with soapUI!!!!

