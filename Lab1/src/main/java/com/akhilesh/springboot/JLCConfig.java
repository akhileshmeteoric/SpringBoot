package com.akhilesh.springboot;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class JLCConfig {

	@Bean
	public DataSource dataSource() {
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/jlcdb");
		ds.setUsername("root");
		ds.setPassword("bangalore");
		ds.setInitialSize(10);
		ds.setMaxActive(15);
		return ds;

	}

	@Bean
	public JdbcTemplate jdbctemplate(DataSource ds) {

		return new JdbcTemplate(ds);
	}

	@Bean(name = "custDAO")
	public CustomerDAO customerDAO() {
		return new JDBCCustomerDAO();

	}

}
