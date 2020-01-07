package com.cognizant.truyum;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TruyumApplication {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(TruyumApplication.class);

	public static void main(String[] args) {
		
		LOGGER.info("Start");
		
		SpringApplication.run(TruyumApplication.class, args);
		
		LOGGER.info("End");
		
	}

}
