package com.q.crud.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@PropertySource("classpath:application.properties")
@EnableTransactionManagement
@ComponentScans(value = { @ComponentScan("com.q.crud.dao"), @ComponentScan("com.q.crud.service") })
public class AppConfig {

	@Autowired
	private Environment env;
	
	

	@Bean
	public LocalSessionFactoryBean getSessionFactory() {

		Properties props = new Properties();
		props.put("hibernate.dialect", env.getProperty("hibernate.dialect"));

		props.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
		props.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));

		LocalSessionFactoryBean localSessionFactory = new LocalSessionFactoryBean();
		localSessionFactory.setHibernateProperties(props);
		localSessionFactory.setPackagesToScan("com.q.crud.entity");
		localSessionFactory.setDataSource(getDataSource());
		return localSessionFactory;

	}

	@Bean
	public HibernateTransactionManager getTransactionManager() {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(getSessionFactory().getObject());
		return transactionManager;
	}
	
	@Bean
	public DataSource getDataSource() {
	    BasicDataSource dataSource = new BasicDataSource();
	    dataSource.setDriverClassName(env.getProperty("hibernate.connection.driver_class"));
	    dataSource.setUrl(env.getProperty("hibernate.connection.url"));
	    dataSource.setUsername(env.getProperty("hibernate.connection.username"));
	    dataSource.setPassword(env.getProperty("hibernate.connection.password"));
	    return dataSource;
	}  
}
