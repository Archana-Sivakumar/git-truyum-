package com.cognizant.truyumAuthentication.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import com.cognizant.truyumAuthentication.TruyumAuthenticationApplication;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	private static final Logger LOGGER = LoggerFactory.getLogger(TruyumAuthenticationApplication.class);
	
    @Override
    public void addCorsMappings(CorsRegistry registry) {
    	
    	LOGGER.info("Start");
    	
    	registry.addMapping("/**").allowedMethods("*").allowedOrigins("*");
    	
    	LOGGER.info("End");
    }

}