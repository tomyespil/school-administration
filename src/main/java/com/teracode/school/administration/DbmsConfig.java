package com.teracode.school.administration;

import javax.sql.DataSource;

import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.configuration.FluentConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DbmsConfig {

	@Bean(name = "datasource", destroyMethod = "close")
	public DataSource buildDataSource(
			@Value("${spring.datasource.url}") String url, @Value("${spring.datasource.driver-class-name}") String driverClass, 
			@Value("${spring.datasource.username}") String username, @Value("${spring.datasource.password}") String password) {
		DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName(driverClass);
        dataSourceBuilder.url(url);
        dataSourceBuilder.username(username);
        dataSourceBuilder.password(password);
        return dataSourceBuilder.build();
	}
	
	@Bean(name = "flyway", initMethod = "migrate")
	public Flyway buildFlyway(DataSource dataSource) {		
		FluentConfiguration fluentConfig = Flyway.configure();
		fluentConfig.dataSource(dataSource);
		fluentConfig.baselineOnMigrate(true);
		Flyway result = fluentConfig.load();
		return result;
	}

}