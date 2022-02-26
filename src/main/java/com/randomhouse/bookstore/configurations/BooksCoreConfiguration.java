package com.randomhouse.bookstore.configurations;

import javax.sql.DataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan("com.randomhouse.bookstore")
@EnableJpaRepositories("com.randomhouse.bookstore.repositories")
@Slf4j
@EntityScan("com.randomhouse.bookstore.entities")
@EnableJpaAuditing
@PropertySource(value = "classpath:application.properties")
@EnableTransactionManagement
public class BooksCoreConfiguration {

    @Bean
    public DataSource datasource(Environment env) {

        var data = new DriverManagerDataSource();
        data.setUrl(env.getProperty("spring.datasource.url"));
        data.setDriverClassName("org.postgresql.Driver");
        data.setUsername(env.getProperty("spring.datasource.username"));
        data.setPassword(env.getProperty("spring.datasource.password"));

        return data;

    }


    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource){
        var em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource);
        em.setPackagesToScan("com.randomhouse.bookstore.entities");
        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        return  em;
    }

    @Bean
    public PlatformTransactionManager transactionManager(LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean) {
        var transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(localContainerEntityManagerFactoryBean.getObject());
        return transactionManager;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }
}


