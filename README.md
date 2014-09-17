secure-rest-webapp-archetype
============================

Secure RESTful Web Services Archetype with Apache Shiro 1.2.3, Jersey 1.18.1 and Google Guice 3.0

Dependencies included
---------------------
- Servlet 2.5
- Jersey 1.18.1
- Guice 3.0
- Apache Shiro 1.2.3
- guice-persist 3.0
- gson 2.2.4
- joda-time 2.4
- JUnit 4.10

Requirements
------------
- Java 7
- Maven 3
- Tomcat 7

Building and Running
---------------------
- Install the Archetype in your local Maven Repo `mvn install`
- Create a New Maven Project from command line:
```bash
mvn archetype:generate -DarchetypeGroupId=com.pampanet 
  -DarchetypeArtifactId=secure-rest-webapp-archetype 
  -DarchetypeVersion=0.1.0-RELEASE 
  -DgroupId=<my.company.name> 
  -DartifactId=<sample> 
  -DarchetypeRepository=local 
  -DinteractiveMode=false
```

Apache Shiro Filters
--------------------
- Shiro's Default Filters: http://shiro.apache.org/web.html#Web-DefaultFilters
- In <code>com.pampanet.sample.shiro.modules.BootstrapShiroModule</code> are all the filters, placed in order.
- You can replace <code>com.pampanet.sample.shiro.modules.ShiroAnnotationsModule</code> with Shiro's default <code>ShiroAopModule</code> class.

Apache Shiro Users Configuration
--------------------------------
- Sample <code>shiro.ini</code> file in <code>src/main/resources</code>
- To configure more Realms and Filters, refer to Shiro's Documentation https://shiro.apache.org/static/current/apidocs/org/apache/shiro/realm/Realm.html
