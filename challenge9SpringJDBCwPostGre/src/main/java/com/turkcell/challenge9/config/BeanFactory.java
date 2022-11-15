package com.turkcell.challenge9.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class BeanFactory {
	
	// bu sınıfta db configuration bean 'leri oluşturulacak..

	@Bean(name = "datasource")
	public DataSource dataSource() {
		// datasource = connection bilgileri
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.postgresql.Driver");
		dataSource.setUrl("jdbc:postgresql://localhost:5432/Challenge9");
		dataSource.setUsername("postgres");
		dataSource.setPassword("zafer1907");
		return dataSource;
	}

	@Bean(name = "jdbcTemplate")
	@DependsOn(value = "datasource")
	public JdbcTemplate jdbcTemplate(@Autowired @Qualifier(value = "datasource") DataSource ds) {
		return new JdbcTemplate(ds);
	}

	@Bean(name = "namedParameterJdbcTemplate")
	@DependsOn(value = "datasource")
	public NamedParameterJdbcTemplate namedParameterJdbcTemplate(
			@Autowired @Qualifier(value = "datasource") DataSource ds) {
		return new NamedParameterJdbcTemplate(ds);
	}
}
