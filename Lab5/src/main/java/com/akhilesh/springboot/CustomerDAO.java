package com.akhilesh.springboot;

import java.util.List;

public interface CustomerDAO {
	public void addCustomer(Customer cust);

	public List<Customer> getAllCustomer();
}
