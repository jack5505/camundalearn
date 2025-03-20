package com.tuit.learn.learncamunda;

import io.camunda.zeebe.spring.client.annotation.Deployment;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Deployment(resources = "test.bpmn")
public class LearncamundaApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearncamundaApplication.class, args);
    }

}
