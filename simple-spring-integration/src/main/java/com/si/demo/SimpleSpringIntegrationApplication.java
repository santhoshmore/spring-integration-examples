package com.si.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.PollableChannel;
@EnableIntegration
@ImportResource("classpath*:/spring-context.xml")
//@ComponentScan(basePackages = "com.si.demo")
@SpringBootApplication
public class SimpleSpringIntegrationApplication{

	public static void main(String[] args) {
		SpringApplication.run(SimpleSpringIntegrationApplication.class, args);
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-context.xml");
		context.start();
		
		MessageChannel input = context.getBean("input", MessageChannel.class);
		PollableChannel output = context.getBean("firstoutput", PollableChannel.class);
		input.send(MessageBuilder.withPayload("spring integration example ").build());
		output.receive();
		System.out.println("recieved: "+ output.receive());
	}

}
