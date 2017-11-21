package com.lushunde.springboot.junit;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan(value = "com.lushunde.springboot")
@ImportResource(locations = { "classpath:applicationContext.xml" })
public class StartBootstarp {
	
    public static void main(String[] args) throws Exception {
        SpringApplication.run(StartBootstarp.class, args);
    }
    
    @PostConstruct
    private void init(){
    	//apiController.getGroupMember(null);
    }
    
    
    @PreDestroy
	private void destroykill(){
		
	}
}