package com.poctcc.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

import com.poctcc.api.enums.ApiServiceName;

public abstract class AbstractService {
	
	@Autowired
	private Environment env;
	
	@Autowired
	protected RestTemplate restTemplate;
	
	protected HttpEntity<String> requestEntity;
	
	protected String defineUrl(ApiServiceName serviceName) {
		String profileActivy = env.getProperty("spring.profiles.active");
		String apiProperty = serviceName.equals(ApiServiceName.AUTH) ? "endpoints-auth" : "endpoints-safim";
		apiProperty += "development".equalsIgnoreCase(profileActivy) ? ".dev" :  ".prod";
		return env.getProperty(apiProperty);
	}
	
	protected void defineHeader(String token) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", token);
		requestEntity = new HttpEntity<String>(headers);
	}

}
