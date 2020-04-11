package com.calisma.spsecurity;

import java.util.Random;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class DBConfig {
	
	@Bean(value = "dataSource")
	public DriverManagerDataSource dataSource() {
		DriverManagerDataSource dm = new DriverManagerDataSource();
		dm.setDriverClassName("com.mysql.jdbc.Driver");
		dm.setUrl("jdbc:mysql://localhost/sakila?useUnicode=true&characterEncoding=utf-8");
		dm.setUsername("root");
		dm.setPassword("");
		return dm;
	}
	
	
	@Bean(value = "randomSum")
	public Random rnd() {
		return new Random();
	} 

}
