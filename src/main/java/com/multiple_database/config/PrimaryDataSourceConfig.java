package com.multiple_database.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class PrimaryDataSourceConfig {

    @Value("${spring.datasource.url}")
    private String dataSourceUrl;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;

    @Value("${spring.datasource.hikari.maximum-pool-size}")
    private int maxPoolSize;

    @Value("${spring.datasource.hikari.minimum-idle-connections}")
    private int minimumIdleConnections;

    @Value("${spring.datasource.hikari.connection-timeout}")
    private int connectionTimeout;

    @Bean(name = "primaryDataSource")
    @Primary
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


    @Bean(name = "primaryJdbcTemplate")
    public JdbcTemplate jdbcTemplate(@Qualifier("primaryDataSource") DataSource primaryDataSource){
        return new JdbcTemplate(primaryDataSource);
    }
}
