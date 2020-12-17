package com.akhilesh.springboot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.stereotype.Repository;

@Repository("custDAO")
public class JDBCCustomerDAO implements CustomerDAO {

	@Autowired
	JdbcTemplate jdbcTemp;

	public void addCustomer(Customer cust) {
		String sql = "insert into customer values(?,?,?,?,?)";
		jdbcTemp.update(sql, cust.getCid(), cust.getCname(), cust.getEmail(), cust.getPhone(), cust.getCity());

	}

	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return null;
	}

}
