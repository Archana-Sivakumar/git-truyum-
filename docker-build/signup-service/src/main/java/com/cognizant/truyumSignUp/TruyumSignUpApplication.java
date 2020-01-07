package com.cognizant.truyumSignUp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class TruyumSignUpApplication {

	public static void main(String[] args) {
		SpringApplication.run(TruyumSignUpApplication.class, args);
	}

}
