jersey-guice-bootstrap
======================

RESTful Web Services Application Sample Project with Jersey 1.18.1 and Google Guice 3.0

Dependencies included
---------------------
- Servlet 2.5
- Jersey 1.18.1
- Guice 3.0
- guice-persist 3.0
- gson 2.2.4
- joda-time 2.4
- JUnit 4.10

Requirements
------------
- Java 7
- Maven 3
- Tomcat 7

Building
--------
- Make the war file <code> mvn clean package </code>
- Deploy the war file in Tomcat 7 with Eclipse or manually

After Deploy on Application Server
----------------------------------
- The REST WS are accessible under /rest/*
- Front-End not yet implemented.