package com.tuit.learn.learncamunda.zeebe;

import io.camunda.zeebe.client.ZeebeClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class ZeebeClientImplement implements CommandLineRunner {

    @Autowired
    private ZeebeClient zeebeClient;

    @Override
    public void run(String... args) throws Exception {
        try {
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
            System.out.println("success");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
