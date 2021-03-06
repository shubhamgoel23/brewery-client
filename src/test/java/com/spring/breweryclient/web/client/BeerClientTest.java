package com.spring.breweryclient.web.client;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.net.URI;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring.breweryclient.web.model.BeerDto;
import com.spring.breweryclient.web.model.CustomerDto;

@SpringBootTest
public class BeerClientTest {

	@Autowired
	BreweryClient client;

	@Test
	void getBeerId() {
		BeerDto dto = client.getBeerById(UUID.randomUUID());
		assertNotNull(dto);
	}

	@Test
	void saveNewBeer() {
		// given
		BeerDto beerDto = BeerDto.builder().beerName("New Beer").build();
		URI uri = client.saveNewBeer(beerDto);
		System.out.println(uri.toString());

	}

	@Test
	void updateBeer() {
		// given
		BeerDto beerDto = BeerDto.builder().beerName("New Beer").build();
		client.updateBeer(UUID.randomUUID(), beerDto);
	}

	@Test
	public void deleteBeer() {
		client.deleteBeer(UUID.randomUUID());
	}

	@Test
	void getCustomerById() {
		CustomerDto dto = client.getCustomerById(UUID.randomUUID());

		assertNotNull(dto);

	}

	@Test
	void saveNewCustomer() {
		// given
		CustomerDto customerDto = CustomerDto.builder().name("Joe").build();

		URI uri = client.saveNewCustomer(customerDto);

		assertNotNull(uri);

		System.out.println(uri.toString());

	}

	@Test
	void updateCustomer() {
		// given
		CustomerDto customerDto = CustomerDto.builder().name("Jim").build();

		client.updateCustomer(UUID.randomUUID(), customerDto);

	}

	@Test
	void deleteCustomer() {
		client.deleteCustomer(UUID.randomUUID());
	}

}
