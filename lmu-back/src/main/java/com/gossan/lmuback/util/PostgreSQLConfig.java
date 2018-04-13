package com.gossan.lmuback.util;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@PropertySource(value = "application.properties", ignoreResourceNotFound = true)
@EnableJpaRepositories(
        entityManagerFactoryRef = "postgresqlEntityManagerFactory",
        transactionManagerRef = "postgresqlTransactionManager",
        basePackages = {"com.gossan.lmuback.dao"}
)
@Profile({"development", "test"})
public class PostgreSQLConfig {

    @Bean(name = "postgresqlDataSource")
    public DataSource postgresqlDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "postgresqlEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean postgresqlEntityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("postgresqlDataSource") DataSource ds
    ){
        return builder.dataSource(ds)
                .packages("com.gossan.lumback.models")
                .persistenceUnit("postgresqlLmuUnit")
                .build();
    }

    @Bean(name = "postgresqlTransactionManager")
    public PlatformTransactionManager postgresqlTransactionManager(
            @Qualifier("postgresqlEntityManagerFactory") EntityManagerFactory emf
    ){
        return new JpaTransactionManager(emf);
    }
}
