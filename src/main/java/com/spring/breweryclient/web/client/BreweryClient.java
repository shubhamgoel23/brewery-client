package com.spring.breweryclient.web.client;

import java.util.UUID;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.spring.breweryclient.web.model.BeerDto;

@Component
@ConfigurationProperties(value="spring.brewery", ignoreUnknownFields = false) //this gonna be the prefix
public class BreweryClient {
	
	private String apihost;
	public final String BEER_PATH_V1 = "api/v1/beer/";
	private final RestTemplate restTemplate;
	
	public BreweryClient(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.build();
	}
	
	public BeerDto getBeerById(UUID id) {
		return restTemplate.getForObject(apihost+BEER_PATH_V1+id.toString(), BeerDto.class);
	}
	
	public void setApihost(String apihost) {
		this.apihost = apihost;
	}
	

}