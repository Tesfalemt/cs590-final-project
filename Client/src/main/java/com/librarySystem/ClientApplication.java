package com.librarySystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ClientApplication implements CommandLineRunner {
	@Autowired
	RestOperations restTemplate;
	@Value("{}")
	String apiGateway;

	public static void main(String[] args) {
		SpringApplication.run(ClientApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {

		// create customers
		Address address1 = new Address("1000 4th st","fairfield","52557");
		Address address2 = new Address("eastcost st","springfield","5345");
		Contact contact1 = new Contact("6428183454","john@gmail.com");
		Contact contact2 = new Contact("8935456679","doe@gmail.com");

		CustomerDto customerDTO1 = new CustomerDto(34, "john",address1, contact1);
		CustomerDto customerDTO2 = new CustomerDto(32, "Doe",address2, contact2);

		restTemplate.postForLocation(apiGateway+"/customers", customerDTO1);
		restTemplate.postForLocation(apiGateway+"/customers", customerDTO2);

		// print customers
		System.out.println(restTemplate.getForEntity(apiGateway+"/customers/12345",Customer.class));
		System.out.println(restTemplate.getForEntity(apiGateway+"/customers12346",Customer.class));


		//2-->Add two books to command service

		Book book1=new Book("A-1-5","core java","oracle ");
		Book book2=new Book("A-1-4","Biography","Tesfalem");

		restTemplate.postForLocation(apiGateway+"/bookcommand",book1);
		restTemplate.postForLocation(apiGateway+"/bookcommand",book2);






	}
	public RestOperations getRestTemplate(){
		return new RestTemplate();
	}
}
