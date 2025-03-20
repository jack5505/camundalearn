This project about working with camunda with zeebe client.
Stack of project 
spring-boot: 3.4.3
java: 17
camunda: 8.2.1
For working you should add this dependency into project.

      <dependency>
            <groupId>io.camunda.spring</groupId>
            <artifactId>spring-boot-starter-camunda</artifactId>
            <version>8.5.18</version>
        </dependency>

and configure application.yml file this configuration 

camunda:
  client:
    zeebe:
      base-url: "http://localhost:26500"

but before it make sure camunda bpm engine and zeebe client is working       
    
