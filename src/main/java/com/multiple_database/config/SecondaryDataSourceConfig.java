package com.multiple_database.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class SecondaryDataSourceConfig {


    @Value("${spring.datasource.secondary.url}")
    private String dataSourceUrl;

    @Value("${spring.datasource.secondary.username}")
    private String username;

    @Value("${spring.datasource.secondary.password}")
    private String password;
    @Value("${spring.datasource.secondary.driver-class-name}")
    private String driverClassName;

    @Value("${spring.datasource.secondary.hikari.maximum-pool-size}")
    private int maxPoolSize;

    @Value("${spring.datasource.secondary.hikari.minimum-idle-connections}")
    private int minimumIdleConnections;

    @Value("${spring.datasource.secondary.hikari.connection-timeout}")
    private int connectionTimeout;

    @Bean(name = "secondaryDataSource")
    public DataSource dataSource() {
        HikariDataSource dataSource = DataSourceBuilder.create()
                .type(HikariDataSource.class)
                .username(username)
                .password(password)
                .url(dataSourceUrl)
                .driverClassName(driverClassName)
                .build();
        dataSource.setMaximumPoolSize(maxPoolSize);
        dataSource.setMinimumIdle(minimumIdleConnections);
        dataSource.setConnectionTimeout(connectionTimeout);
        return dataSource;
    }


    @Bean(name = "secondaryJdbcTemplate")
    public JdbcTemplate jdbcTemplate(@Qualifier("secondaryDataSource") DataSource secondaryDataSource){
        return new JdbcTemplate(secondaryDataSource);
    }
}
