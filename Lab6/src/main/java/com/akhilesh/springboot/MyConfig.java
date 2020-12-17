package com.akhilesh.springboot;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

@SpringBootApplication
public class MyConfig {

	@Bean
	public DataSource dataSource() {

		DriverManagerDataSource bds = new DriverManagerDataSource();
		bds.setDriverClassName("com.mysql.jdbc.Driver");
		bds.setUrl("jdbc:mysql://localhost:3306/jlcdb");
		bds.setUsername("root");
		bds.setPassword("bangalore");

		return bds;

	}

	@Bean(name = "jlcSessionfactory")
	public LocalSessionFactoryBean sessionFactory(DataSource dataSource) {

		LocalSessionFactoryBean factory = new LocalSessionFactoryBean();
		factory.setDataSource(dataSource);

		Properties probs = new Properties();
		probs.put("hibernate.show_sql", "true");
		probs.put("hibernate.format_sql", "true");
		probs.put("hibernate.hbm2dll.auto", "create");
		probs.put("hibernate.transaction.factory_class", "org.hibernate.transaction.JDBCTransactionFactory");
		factory.setHibernateProperties(probs);
		factory.setPackagesToScan("com.akhilesh.springboot");
		return factory;
	}

	@Bean(name = "jlcHibernatetemplate")
	public HibernateTemplate hibernateTemplate(SessionFactory sessionFactory) {

		return new HibernateTemplate(sessionFactory);
	}

	public PlatformTransactionManager transactionManager(SessionFactory sessionFactory) {
		return new HibernateTransactionManager(sessionFactory);
	}
}
