package com.tuit.learn.learncamunda.zeebe;

import io.camunda.zeebe.client.ZeebeClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ZeebeConnectionCheck implements CommandLineRunner {

    @Autowired
    private ZeebeClient zeebeClient;

    @Override
    public void run(String... args) throws Exception {
        try{
            zeebeClient.newTopologyRequest().send().join();
            System.out.println("Connected to Zeebe");
        }catch (Exception e){
            System.out.println("Failed to connect to Zeebe");
        }
    }
}
