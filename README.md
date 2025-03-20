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

but before it make sure camunda bpm engine and zeebe client is working.

In order to deployment to new .bpmn extension into camunda engine you might use annotation @Deployment and refer there bpmn model
then spring automatically will deploy this bpm proces into camunda engine.In order to run code with that bpmn process you might call following zeebeclient api 

zeebeClient.newCreateInstanceCommand()
                    .bpmnProcessId("Process_0d7nws1")
                    .latestVersion()
                    .variable(
                            "variables",
                            Map.of(
                                    "name", "John",
                                    "age", 30
                            )
                    )
                    .send()
                    .exceptionally(throwable ->
                    {
                        System.out.println("error " + throwable.getMessage());
                        throw new RuntimeException(throwable);
                    }); 

full example of code into project.
    
