package com.spring.breweryclient.web.client;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring.breweryclient.web.model.BeerDto;

@SpringBootTest
public class BeerClientTest{
	
	@Autowired
	BreweryClient client;
	
	@Test
	void getBeerId() {
		BeerDto dto = client.getBeerById(UUID.randomUUID());
		assertNotNull(dto);
	}

}
