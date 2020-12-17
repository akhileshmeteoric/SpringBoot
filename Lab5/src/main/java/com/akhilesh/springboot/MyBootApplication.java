package com.akhilesh.springboot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.akhilesh.springboot")
public class MyBootApplication implements CommandLineRunner {

	@Autowired
	CustomerDAO cdao;

	public static void main(String[] args) {

		SpringApplication.run(MyBootApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// 1. addCustomer
		Customer cust1 = new Customer(113, "Ganesh", "ganesh@gmail.com", 4444, "Blore");
		cdao.addCustomer(cust1);

		// 2. getAllCustomer

		System.out.println("getAllCustomer");
		List<Customer> list = cdao.getAllCustomer();
		list.forEach(cust -> System.out.println(cust));

	}
}
