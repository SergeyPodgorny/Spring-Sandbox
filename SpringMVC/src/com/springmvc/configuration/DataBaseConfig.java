package com.springmvc.configuration;

import java.util.Properties;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EnableJpaRepositories("com.springmvc.repository")
@EnableTransactionManagement
@PropertySource("classpath:db")
public class DataBaseConfig {
	
	@Autowired
	private Environment environment;
	
	@Bean
	public BasicDataSource basicDataSource() {
		
		BasicDataSource basicDataSource = new BasicDataSource();
		basicDataSource.setDriverClassName(environment.getProperty("jdbc.driverClassName"));
		basicDataSource.setUrl(environment.getProperty("jdbc.url"));
		basicDataSource.setUsername(environment.getProperty("jdbc.user"));
		basicDataSource.setPassword(environment.getProperty("jdbc.pass"));
		return basicDataSource;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityMangerFactoryBean() {
		
		LocalContainerEntityManagerFactoryBean entityMangerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		entityMangerFactoryBean.setDataSource(basicDataSource());
		entityMangerFactoryBean.setPackagesToScan("com.springmvc.entity");
		entityMangerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		entityMangerFactoryBean.setJpaProperties(hibernateProperties());
		entityMangerFactoryBean.afterPropertiesSet();
		return entityMangerFactoryBean;
	}
	
	
	public PlatformTransactionManager transActionManager() {
		
		JpaTransactionManager manager = new JpaTransactionManager();
		manager.setEntityManagerFactory(entityMangerFactoryBean().getObject());
		return manager;
	}
	
	
	
	private Properties hibernateProperties() {
		Properties hibernateProperties = new Properties();
		hibernateProperties.setProperty("hibernate.dialect", environment.getProperty("hibernate.dialect"));
		hibernateProperties.setProperty("hibernate.show_sql", environment.getProperty("hibernate.show_sql"));
		hibernateProperties.setProperty("hibernate.hbm2ddl.auto", environment.getProperty("hibernate.hbm2ddl.auto"));
		hibernateProperties.setProperty("hibernate.temp.use_jdbc_metadata_defaults", environment.getProperty("hibernate.temp.use_jdbc_metadata_defaults"));
		return hibernateProperties;
	}
	
	
	
}
