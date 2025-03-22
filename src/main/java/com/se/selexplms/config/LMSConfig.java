package com.se.selexplms.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages="com.se")
public class LMSConfig {
	
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver=new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	
	@Bean
	public LocalSessionFactoryBean getSessionFactory() {
		LocalSessionFactoryBean lfb=new LocalSessionFactoryBean();
		lfb.setDataSource(getDataSource());
		lfb.setHibernateProperties(getProperties());
		lfb.setPackagesToScan("com.se.selexplms.entity");
		return lfb;
	}

	
	public Properties getProperties() {
		Properties prop=new Properties();
		prop.put("hibernate.show_sql", true);
		prop.put("hibernate.format_sql", true);
		prop.put("hibernate.hbm2ddl.auto", "update");
		//prop.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		return prop;
	}

	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource ds=new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/instructor-details-schema");
		ds.setUsername("root");
		ds.setPassword("Abhi@8225");
		
		return ds;
	}
	
	@Bean
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager manager=new HibernateTransactionManager(sessionFactory);
		return manager;
	}
	

}
