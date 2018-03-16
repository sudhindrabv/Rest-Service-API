package com.firstapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import lombok.extern.log4j.Log4j2;

@SpringBootApplication
@ComponentScan({ "com.firstapp"})
@Log4j2 // or: @Log @CommonsLog @Log4j @Log4j2 @XSlf4j
public class SpringServiceApplication {


	public static void main(String[] args) {
		log.info("starting Application");
		SpringApplication.run(SpringServiceApplication.class, args);
		log.info("Rest Service started");
	}
}
