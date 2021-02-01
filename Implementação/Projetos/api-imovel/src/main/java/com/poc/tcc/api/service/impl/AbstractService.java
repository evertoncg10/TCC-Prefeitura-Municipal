package com.poc.tcc.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

import com.poc.tcc.api.enums.ApiServiceName;

public abstract class AbstractService {
	
	@Autowired
	protected Environment env;
	
	@Autowired
	protected RestTemplate restTemplate;
	
	protected HttpEntity<String> request;
	
	protected String defineUrl(ApiServiceName serviceName) {
		String profileActivy = env.getProperty("spring.profiles.active");
		String apiProperty = defineProperty(serviceName);
		apiProperty += "development".equalsIgnoreCase(profileActivy) ? ".dev" :  ".prod";
		return env.getProperty(apiProperty);
	}
	
	private String defineProperty(ApiServiceName serviceName) {
		String property;
		switch (serviceName) {
		case AUTH:
			property = "endpoints-auth";
			break;
		case CIDADAO:
			property = "endpoints-cidadao";
			break;
			
		case STUR:
			property = "endpoints-stur";
			break;

		default:
			property = "";
			break;
		}
		return property;
	}

	protected void defineHeader(String token) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", token);
		request = new HttpEntity<String>(headers);
	}

}
