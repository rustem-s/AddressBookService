# AddressBookService test task application.

Used technologies and products:

Database: MySQL 5.7 (Database scripts are located in $PROJECT_HOME/ejb/src/test/sql)
JPA: Hiberbate 4
Application server: WildFly 9
EJB 3.2
RESTful Web services framework: Jersey 2.15
JAXB: FasterXML Jackson 2.5.0
Project build management tool: Apache Maven
IDE: IntelliJ IDEA 14
JDK 1.8

Application deployed on cloud https://openshift.redhat.com.

List of persons, GET request: http://appserver01-rustems.rhcloud.com/rest-service/person/list
Get person by id, GET request: http://appserver01-rustems.rhcloud.com/rest-service/person/show/{id}
Create person, POST request: http://appserver01-rustems.rhcloud.com/rest-service/person/create
Update person by id, POST request: http://appserver01-rustems.rhcloud.com/rest-service/person/update/{id}
Delete person by id, DELETE request: http://appserver01-rustems.rhcloud.com/rest-service/person/delete/{id}

Source located in Git repository: https://github.com/rustem-s/AddressBookService

Some postrequisites:

Wildfly configuration needed.

To fix "Cross origin resource sharing" problem on clients side you need to add to the service responses this headers:

Access-Control-Allow-Origin="*"
Access-Control-Allow-Credentials="true"
Access-Control-Allow-Methods="GET, POST, DELETE, PUT, OPTIONS, HEAD"
Access-Control-Allow-Headers="Content-Type, Accept, X-Requested-With"

In WildFly need to add rows in standalone.xml:

<subsystem xmlns="urn:jboss:domain:undertow:2.0">
...
    <host name="default-host" alias="localhost">
    ...
        <filter-ref name="access-control-allow-origin-header"/>
        <filter-ref name="access-control-allow-credentials-header"/>
        <filter-ref name="access-control-allow-methods-header"/>
        <filter-ref name="access-control-allow-headers-header"/>
    </host>
...
    <filters>
    ...
        <response-header name="access-control-allow-origin-header" header-name="Access-Control-Allow-Origin" header-value="*"/>
        <response-header name="access-control-allow-credentials-header" header-name="Access-Control-Allow-Credentials" header-value="true"/>
        <response-header name="access-control-allow-methods-header" header-name="Access-Control-Allow-Methods" header-value="GET, POST, DELETE, PUT, OPTIONS, HEAD"/>
        <response-header name="access-control-allow-headers-header" header-name="Access-Control-Allow-Headers" header-value="Content-Type, Accept, X-Requested-With"/>
    ...
    </filters>
</subsystem>