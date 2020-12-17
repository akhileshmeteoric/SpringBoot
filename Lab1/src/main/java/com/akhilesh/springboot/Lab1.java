package com.akhilesh.springboot;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Lab1 {
public static void main(String[] args) {
	
	AnnotationConfigApplicationContext ctx= new AnnotationConfigApplicationContext(MyConfig.class);
	CustomerDAO cdao=(CustomerDAO)ctx.getBean("custDAO");
	
	//1. addCustomer
	Customer cust1= new Customer(113, "Akhilesh", "akhilesh@gmail.com", 9999, "Blore");
	cdao.addCustomer(cust1);
	
	//2. getAllCustomer
	
	System.out.println("getAllCustomer");
	List<Customer> list = cdao.getAllCustomer();
	list.forEach(cust -> System.out.println(cust));
}
}
