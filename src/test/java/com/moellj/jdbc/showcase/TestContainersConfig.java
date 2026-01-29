package com.moellj.jdbc.showcase;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.testcontainers.containers.PostgreSQLContainer;

import java.util.List;

@TestConfiguration(proxyBeanMethods = false)
public class TestContainersConfig {

    @Bean
    @ServiceConnection
    PostgreSQLContainer<?> postgreSQLContainer() {
        PostgreSQLContainer postgres = new PostgreSQLContainer<>("postgres:17.4-alpine")
                .withUsername("postgres")
                .withPassword("postgres");
        postgres.setPortBindings(List.of("5431:5432"));
        return postgres;
    }
}
