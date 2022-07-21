package com.example.random_chat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

@SpringBootApplication
public class RandomChatApplication {

    public static void main(String[] args) {
        SpringApplication.run(RandomChatApplication.class, args);
    }

    @Bean
    public DataSourceProperties getDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    DataSource dataSource() {
        return getDataSourceProperties().initializeDataSourceBuilder().build();
    }
}
