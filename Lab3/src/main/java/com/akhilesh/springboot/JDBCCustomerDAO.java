package com.akhilesh.springboot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
@Repository("custDAO")
public class JDBCCustomerDAO implements CustomerDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public void addCustomer(Customer cust) {
		String sql = "insert into customers values(?,?,?,?,?)";
		jdbcTemplate.update(sql, cust.getCid(), cust.getCname(), cust.getEmail(), cust.getPhone(), cust.getCity());
	}

	@Override
	public List<Customer> getAllCustomer() {

		String sql = "select * from customers";
		List<Customer> list = jdbcTemplate.query(sql, new CustomerRowMapper());
		return list;
	}

}
