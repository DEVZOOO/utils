package com.judy.utils.database.config;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@ComponentScan(basePackages = {"com.judy.utils.database.*"})
public class DatabaseConfig {

    @Bean(name = "dataSource")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.hikari")
    public DataSource databaseDatasource() {
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name = "rainAlertEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean rainAlertEntityManagerFactory(
        EntityManagerFactoryBuilder builder,
        @Qualifier("dataSource") DataSource dataSource
    ) {

        Map<String, String> properties = new HashMap<>();

        return builder
            .dataSource(dataSource)
            .packages("com.judy.utils.database")
            .properties(properties)
            .persistenceUnit("persistenceUnit")
            .build();
    }

    @Primary
    @Bean(name = "rainAlertTransactionManager")
    public PlatformTransactionManager rainAlertTransactionManager(
        @Qualifier("rainAlertEntityManagerFactory") EntityManagerFactory entityManagerFactory
    ) {
        return new JpaTransactionManager(entityManagerFactory);
    }

    @Configuration
    @EnableJpaRepositories(
        basePackages = {
            "com.judy.utils.database"
        },
        entityManagerFactoryRef = "rainAlertEntityManagerFactory",
        transactionManagerRef = "rainAlertTransactionManager")
    static class databaseJpaRepositoriesConfig {
    }


}
